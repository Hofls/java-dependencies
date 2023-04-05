package hofls.com.github.rest.api.patch.school.mapper;

import hofls.com.github.rest.api.patch.common.PatchMapperUtils;
import hofls.com.github.rest.api.patch.school.dto.School;
import hofls.com.github.rest.api.patch.school.dto.SchoolPatch;
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