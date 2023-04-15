package hofls.com.github.rest.patch.school.service;

import hofls.com.github.rest.patch.common.IPatchService;
import hofls.com.github.rest.patch.common.Identifiable;
import hofls.com.github.rest.patch.common.PatchListService;
import hofls.com.github.rest.patch.school.dto.School;
import hofls.com.github.rest.patch.school.dto.SchoolPatch;
import hofls.com.github.rest.patch.school.mapper.SchoolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SchoolService implements IPatchService<School.SKEUnit, SchoolPatch.SKEUnit> {

    @Autowired
    private PatchListService<School.SKEUnit, SchoolPatch.SKEUnit> patchService;

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
    public School.SKEUnit newEntity() {
        return new School.SKEUnit();
    }

}
