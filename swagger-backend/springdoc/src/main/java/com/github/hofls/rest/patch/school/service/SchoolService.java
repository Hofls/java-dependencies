package com.github.hofls.rest.patch.school.service;

import com.github.hofls.rest.patch.common.IPatchService;
import com.github.hofls.rest.patch.common.Identifiable;
import com.github.hofls.rest.patch.common.PatchListService;
import com.github.hofls.rest.patch.school.dto.School;
import com.github.hofls.rest.patch.school.dto.SchoolPatch;
import com.github.hofls.rest.patch.school.mapper.SchoolMapper;
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
    public void toEntity(School.SKEUnit entity, SchoolPatch.SKEUnit patch) {
        SchoolMapper.INSTANCE.toEntity(entity, patch);
    }

    @Override
    public School.SKEUnit newEntity() {
        return new School.SKEUnit();
    }

}
