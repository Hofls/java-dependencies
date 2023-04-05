package hofls.com.github.rest.api.patch.game.card.service;

import hofls.com.github.rest.api.patch.game.card.dto.GameCard;
import hofls.com.github.rest.api.patch.game.card.dto.GameCardPatch;
import hofls.com.github.rest.api.patch.common.PatchOperation;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Parameter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class GameCardService {

    public void applyPatch(GameCard gameCard, GameCardPatch patch) {
        if (patch.getName() != null) {
            gameCard.setName(patch.getName());
        }
        if (patch.getPoints() != null) {
            gameCard.setPoints(patch.getPoints().equals("") ? null : Long.valueOf(patch.getPoints()));
        }
        if (patch.getDate() != null) {
            gameCard.setDate(LocalDate.parse(patch.getDate()));
        }

        if (!CollectionUtils.isEmpty(patch.getMarks())) {
            if (gameCard.getMarks() == null) {
                gameCard.setMarks(new ArrayList<>());
            }

            for (GameCardPatch.Mark patchMark : patch.getMarks()) {
                if (patchMark.getOperation() == PatchOperation.ADD) {
                    GameCard.Mark mark = new GameCard.Mark();
                    if (patchMark.getId() == null) {
                        mark.setId(UUID.randomUUID());
                    } else {
                        mark.setId(UUID.fromString(patchMark.getId()));
                    }
                    mark.setTime(LocalTime.parse(patchMark.getTime(), DateTimeFormatter.ofPattern("HH:mm")));
                    mark.setValue(Double.parseDouble(patchMark.getValue()));
                    gameCard.getMarks().add(mark);
                } else if (patchMark.getOperation() == PatchOperation.REPLACE) {
                    UUID patchMarkId = UUID.fromString(patchMark.getId());
                    GameCard.Mark mark = gameCard.getMarks().stream()
                            .filter(m -> m.getId().equals(patchMarkId))
                            .findFirst().orElse(null); // replace with orElseThrow
                    if (mark == null) {
                        throw new RuntimeException("Mark not found. Id - " + patchMark.getId());
                    }
                    mark.setTime(LocalTime.parse(patchMark.getTime(), DateTimeFormatter.ofPattern("HH:mm")));
                    mark.setValue(Double.parseDouble(patchMark.getValue()));
                } else if (patchMark.getOperation() == PatchOperation.REMOVE) {
                    UUID patchMarkId = UUID.fromString(patchMark.getId());
                    gameCard.getMarks().removeIf(m -> m.getId().equals(patchMarkId));
                }
            }
        }

    }

}
