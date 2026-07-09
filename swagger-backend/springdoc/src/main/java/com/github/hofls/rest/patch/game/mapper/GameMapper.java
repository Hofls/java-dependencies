package com.github.hofls.rest.patch.game.mapper;

import com.github.hofls.rest.patch.common.PatchMapperUtils;
import com.github.hofls.rest.patch.game.dto.Game;
import com.github.hofls.rest.patch.game.dto.GamePatch;
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