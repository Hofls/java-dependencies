package hofls.com.github.rest.api.patch.game.card.mapper;

import hofls.com.github.rest.api.patch.common.MapperUtils;
import hofls.com.github.rest.api.patch.game.card.dto.GameCard;
import hofls.com.github.rest.api.patch.game.card.dto.GameCardPatch;
import hofls.com.github.rest.api.patch.school.dto.School;
import hofls.com.github.rest.api.patch.school.dto.SchoolPatch;
import org.apache.commons.lang3.time.DateUtils;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = { MapperUtils.class })
public interface GameCardMapper {

    GameCardMapper INSTANCE = Mappers.getMapper( GameCardMapper.class );

    GameCard toEntity(GameCardPatch patch);



}