package hofls.com.github.rest.api.patch.game.card.mapper;

import hofls.com.github.rest.api.patch.common.MapperUtils;
import hofls.com.github.rest.api.patch.game.card.dto.GameCard;
import hofls.com.github.rest.api.patch.game.card.dto.GameCardPatch;
import hofls.com.github.rest.api.patch.school.dto.School;
import hofls.com.github.rest.api.patch.school.dto.SchoolPatch;
import org.apache.commons.lang3.time.DateUtils;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = { MapperUtils.class })
public interface GameCardMapper {

    GameCardMapper INSTANCE = Mappers.getMapper( GameCardMapper.class );

    @Mapping(target = "marks", ignore = true)
    void toEntity(@MappingTarget GameCard entity, GameCardPatch patch);

}