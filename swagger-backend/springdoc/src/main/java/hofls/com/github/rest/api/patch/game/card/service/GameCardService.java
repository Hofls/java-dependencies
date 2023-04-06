package hofls.com.github.rest.api.patch.game.card.service;

import hofls.com.github.rest.api.patch.common.IPatchableEntity;
import hofls.com.github.rest.api.patch.common.Identifiable;
import hofls.com.github.rest.api.patch.common.PatchListService;
import hofls.com.github.rest.api.patch.game.card.dto.GameCard;
import hofls.com.github.rest.api.patch.game.card.dto.GameCardPatch;
import hofls.com.github.rest.api.patch.game.card.mapper.GameCardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GameCardService implements IPatchableEntity {

    @Autowired
    private PatchListService<GameCard.Mark, GameCardPatch.Mark> patchService;

    public void applyPatch(GameCard entity, GameCardPatch patch) {
        GameCardMapper.INSTANCE.toEntity(entity, patch);

        if (entity.getMarks() == null) entity.setMarks(new ArrayList<>());
        patchService.applyPatch(entity.getMarks(), patch.getMarks(), this);
    }

    @Override
    public void toEntity(Object entity, Object patch) {
        GameCardMapper.INSTANCE.toEntity((GameCard.Mark) entity, (GameCardPatch.Mark) patch);
    }

    @Override
    public Identifiable newEntity() {
        return new GameCard.Mark();
    }

}
