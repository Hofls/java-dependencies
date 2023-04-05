package hofls.com.github.rest.api.patch.game.card.mapper;

import hofls.com.github.rest.api.patch.common.PatchMapperUtils;
import hofls.com.github.rest.api.patch.game.card.dto.GameCard;
import hofls.com.github.rest.api.patch.game.card.dto.GameCardPatch;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = { PatchMapperUtils.class })
public interface GameCardMapper {

    GameCardMapper INSTANCE = Mappers.getMapper( GameCardMapper.class );

    @Mapping(target = "marks", ignore = true)
    void toEntity(@MappingTarget GameCard entity, GameCardPatch patch);

    void toEntity(@MappingTarget GameCard.Mark entity, GameCardPatch.Mark patch);

}