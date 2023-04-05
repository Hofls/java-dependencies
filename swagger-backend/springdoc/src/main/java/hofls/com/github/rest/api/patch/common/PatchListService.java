package hofls.com.github.rest.api.patch.common;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.UUID;

@Service
public class PatchListService <T extends Identifiable> {

    public void applyPatch(List<T> units, List<IPatch> patchUnits, IPatchableEntity patchableEntity) {
        if (CollectionUtils.isEmpty(patchUnits)) {
            return;
        }

        for (IPatch patchUnit : patchUnits) {
            if (patchUnit.getOperation() == PatchOperation.ADD) {
                Identifiable unit = patchableEntity.newEntity();
                patchableEntity.toEntity(unit, patchUnit);
                if (patchUnit.getId() == null) {
                    unit.setId(UUID.randomUUID());
                }
                units.add((T) unit);
            } else if (patchUnit.getOperation() == PatchOperation.REPLACE) {
                UUID patchUnitId = UUID.fromString(patchUnit.getId());
                Identifiable unit = units.stream()
                        .filter(u -> u.getId().equals(patchUnitId))
                        .findFirst().orElse(null); // replace with orElseThrow
                if (unit == null) {
                    throw new RuntimeException("Entity not found. Id - " + patchUnit.getId());
                }
                patchableEntity.toEntity(unit, patchUnit);
            } else if (patchUnit.getOperation() == PatchOperation.REMOVE) {
                UUID patchUnitId = UUID.fromString(patchUnit.getId());
                units.removeIf(u -> u.getId().equals(patchUnitId));
            }
        }

    }

}
