package hofls.com.github.rest.api.patch.game.card.service;

import hofls.com.github.rest.api.patch.game.card.dto.GameCard;
import hofls.com.github.rest.api.patch.game.card.dto.GameCardPatch;
import hofls.com.github.rest.api.patch.common.PatchOperation;
import hofls.com.github.rest.api.patch.game.card.mapper.GameCardMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class GameCardService {

    public void applyPatch(GameCard gameCard, GameCardPatch patch) {
        GameCardMapper.INSTANCE.toEntity(gameCard, patch);

        if (!CollectionUtils.isEmpty(patch.getMarks())) {
            if (gameCard.getMarks() == null) {
                gameCard.setMarks(new ArrayList<>());
            }

            for (GameCardPatch.Mark patchMark : patch.getMarks()) {
                if (patchMark.getOperation() == PatchOperation.ADD) {
                    GameCard.Mark mark = new GameCard.Mark();
                    GameCardMapper.INSTANCE.toEntity(mark, patchMark);
                    if (mark.getId() == null) {
                        mark.setId(UUID.randomUUID());
                    }
                    gameCard.getMarks().add(mark);
                } else if (patchMark.getOperation() == PatchOperation.REPLACE) {
                    UUID patchMarkId = UUID.fromString(patchMark.getId());
                    GameCard.Mark mark = gameCard.getMarks().stream()
                            .filter(m -> m.getId().equals(patchMarkId))
                            .findFirst().orElse(null); // replace with orElseThrow
                    if (mark == null) {
                        throw new RuntimeException("Mark not found. Id - " + patchMark.getId());
                    }
                    GameCardMapper.INSTANCE.toEntity(mark, patchMark);
                } else if (patchMark.getOperation() == PatchOperation.REMOVE) {
                    UUID patchMarkId = UUID.fromString(patchMark.getId());
                    gameCard.getMarks().removeIf(m -> m.getId().equals(patchMarkId));
                }
            }
        }

    }

}
