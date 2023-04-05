package hofls.com.github.rest.api.patch.school.service;

import hofls.com.github.rest.api.patch.common.PatchOperation;
import hofls.com.github.rest.api.patch.game.card.dto.GameCard;
import hofls.com.github.rest.api.patch.game.card.dto.GameCardPatch;
import hofls.com.github.rest.api.patch.school.dto.School;
import hofls.com.github.rest.api.patch.school.dto.SchoolPatch;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class SchoolService {

    public void applyPatch(School school, SchoolPatch patch) {
        if (patch.getAddress() != null) {
            school.setAddress(patch.getAddress());
        }
        if (patch.getStudentsCount() != null) {
            school.setStudentsCount(Long.valueOf(patch.getStudentsCount()));
        }

        if (!CollectionUtils.isEmpty(patch.getSkeUnits())) {
            if (school.getSkeUnits() == null) {
                school.setSkeUnits(new ArrayList<>());
            }

            for (SchoolPatch.SKEUnit patchUnit : patch.getSkeUnits()) {
                if (patchUnit.getOperation() == PatchOperation.ADD) {
                    School.SKEUnit unit = new School.SKEUnit();
                    unit.setId(ThreadLocalRandom.current().nextLong(1000));
                    unit.setActive(Boolean.valueOf(patchUnit.getActive()));
                    school.getSkeUnits().add(unit);
                } else if (patchUnit.getOperation() == PatchOperation.REPLACE) {
                    Long patchUnitId = Long.valueOf(patchUnit.getId());
                    School.SKEUnit unit = school.getSkeUnits().stream()
                            .filter(u -> u.getId().equals(patchUnitId))
                            .findFirst().orElse(null); // replace with orElseThrow
                    if (unit == null) {
                        throw new RuntimeException("Unit not found. Id - " + patchUnit.getId());
                    }
                    unit.setActive(Boolean.valueOf(patchUnit.getActive()));
                } else if (patchUnit.getOperation() == PatchOperation.REMOVE) {
                    Long patchUnitId = Long.valueOf(patchUnit.getId());
                    school.getSkeUnits().removeIf(u -> u.getId().equals(patchUnitId));
                }
            }
        }

    }

}
