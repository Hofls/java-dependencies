package hofls.com.github.rest.patch.game.service;

import hofls.com.github.rest.patch.common.IPatchService;
import hofls.com.github.rest.patch.common.PatchListService;
import hofls.com.github.rest.patch.game.dto.Game;
import hofls.com.github.rest.patch.game.dto.GamePatch;
import hofls.com.github.rest.patch.game.mapper.GameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GameService implements IPatchService<Game.Mark, GamePatch.Mark> {

    @Autowired
    private PatchListService<Game.Mark, GamePatch.Mark> patchService;

    public void applyPatch(Game entity, GamePatch patch) {
        GameMapper.INSTANCE.toEntity(entity, patch);

        if (entity.getMarks() == null) entity.setMarks(new ArrayList<>());
        patchService.applyPatch(entity.getMarks(), patch.getMarks(), this);
    }

    @Override
    public void toEntity(Object entity, Object patch) {
        GameMapper.INSTANCE.toEntity((Game.Mark) entity, (GamePatch.Mark) patch);
    }

    @Override
    public Game.Mark newEntity() {
        return new Game.Mark();
    }

}
