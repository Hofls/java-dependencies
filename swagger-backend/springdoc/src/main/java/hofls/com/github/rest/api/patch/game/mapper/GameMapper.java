package hofls.com.github.rest.api.patch.game.mapper;

import hofls.com.github.rest.api.patch.common.PatchMapperUtils;
import hofls.com.github.rest.api.patch.game.dto.Game;
import hofls.com.github.rest.api.patch.game.dto.GamePatch;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = { PatchMapperUtils.class })
public interface GameMapper {

    GameMapper INSTANCE = Mappers.getMapper( GameMapper.class );

    @Mapping(target = "marks", ignore = true)
    void toEntity(@MappingTarget Game entity, GamePatch patch);

    void toEntity(@MappingTarget Game.Mark entity, GamePatch.Mark patch);

}