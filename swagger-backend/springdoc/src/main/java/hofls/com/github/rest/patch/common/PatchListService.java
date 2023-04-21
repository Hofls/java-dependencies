package hofls.com.github.rest.patch.common;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.UUID;

@Service
public class PatchListService <I extends Identifiable, P extends IPatch> {

    public void applyPatch(List<I> units, List<P> patchUnits, IPatchService<I, P> patchService) {
        if (CollectionUtils.isEmpty(patchUnits)) {
            return;
        }

        for (P patchUnit : patchUnits) {
            if (patchUnit.getOperation() == PatchOperation.ADD) {
                I unit = patchService.newEntity();
                patchService.toEntity(unit, patchUnit);
                if (patchUnit.getId() == null) {
                    UUID generatedId = UUID.randomUUID();
                    patchUnit.setId(generatedId.toString());
                    unit.setId(UUID.randomUUID());
                }
                throwIfDuplicate(units, unit);
                units.add((I) unit);
            } else if (patchUnit.getOperation() == PatchOperation.REPLACE) {
                UUID patchUnitId = UUID.fromString(patchUnit.getId());
                I unit = units.stream()
                        .filter(u -> u.getId().equals(patchUnitId))
                        .findFirst().orElse(null); // replace with orElseThrow
                if (unit == null) {
                    throw new RuntimeException("Entity not found. Id - " + patchUnit.getId());
                }
                patchService.toEntity(unit, patchUnit);
            } else if (patchUnit.getOperation() == PatchOperation.REMOVE) {
                UUID patchUnitId = UUID.fromString(patchUnit.getId());
                units.removeIf(u -> u.getId().equals(patchUnitId));
            }
        }

    }

    private void throwIfDuplicate(List<I> units, I unit) {
        UUID duplicateId = units.stream()
                .map(Identifiable::getId)
                .filter(id -> id.equals(unit.getId()))
                .findFirst().orElse(null);
        if (duplicateId != null) {
            throw new RuntimeException("Duplicate ID - " + duplicateId);
        }
    }

}
