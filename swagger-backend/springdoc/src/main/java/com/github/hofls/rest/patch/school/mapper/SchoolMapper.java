package com.github.hofls.rest.patch.school.mapper;

import com.github.hofls.rest.patch.common.PatchMapperUtils;
import com.github.hofls.rest.patch.school.dto.School;
import com.github.hofls.rest.patch.school.dto.SchoolPatch;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = { PatchMapperUtils.class })
public interface SchoolMapper {

    SchoolMapper INSTANCE = Mappers.getMapper( SchoolMapper.class );

    @Mapping(target = "skeUnits", ignore = true)
    void toEntity(@MappingTarget School entity, SchoolPatch patch);

    void toEntity(@MappingTarget School.SKEUnit entity, SchoolPatch.SKEUnit patch);

}