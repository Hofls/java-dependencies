package hofls.com.github.rest.api.patch.school.mapper;

import hofls.com.github.rest.api.patch.common.MapperUtils;
import hofls.com.github.rest.api.patch.school.dto.School;
import hofls.com.github.rest.api.patch.school.dto.SchoolPatch;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = { MapperUtils.class })
public interface SchoolMapper {

    SchoolMapper INSTANCE = Mappers.getMapper( SchoolMapper.class );

    School toEntity(SchoolPatch patch);


}