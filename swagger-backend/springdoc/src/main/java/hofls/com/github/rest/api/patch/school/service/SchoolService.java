package hofls.com.github.rest.api.patch.school.service;

import hofls.com.github.rest.api.patch.common.IPatchableEntity;
import hofls.com.github.rest.api.patch.common.Identifiable;
import hofls.com.github.rest.api.patch.common.PatchListService;
import hofls.com.github.rest.api.patch.school.dto.School;
import hofls.com.github.rest.api.patch.school.dto.SchoolPatch;
import hofls.com.github.rest.api.patch.school.mapper.SchoolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SchoolService implements IPatchableEntity {

    @Autowired
    private PatchListService patchService;

    public void applyPatch(School school, SchoolPatch patch) {
        SchoolMapper.INSTANCE.toEntity(school, patch);

        if (school.getSkeUnits() == null) school.setSkeUnits(new ArrayList<>());
        patchService.applyPatch(school.getSkeUnits(), patch.getSkeUnits(), this);
    }

    @Override
    public void toEntity(Object entity, Object patch) {
        SchoolMapper.INSTANCE.toEntity((School.SKEUnit) entity, (SchoolPatch.SKEUnit) patch);
    }

    @Override
    public Identifiable newEntity() {
        return new School.SKEUnit();
    }

}
