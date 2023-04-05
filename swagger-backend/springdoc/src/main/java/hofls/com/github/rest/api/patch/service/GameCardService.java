package hofls.com.github.rest.api.patch.service;

import hofls.com.github.rest.api.patch.dto.GameCard;
import hofls.com.github.rest.api.patch.dto.GameCardPatch;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
            gameCard.setPoints(Long.valueOf(patch.getPoints()));
        }
        if (patch.getDate() != null) {
            gameCard.setDate(LocalDate.parse(patch.getDate()));
        }

        if (!CollectionUtils.isEmpty(patch.getAddMarks())) {
            if (gameCard.getMarks() == null) {
                gameCard.setMarks(new ArrayList<>());
            }
            for (GameCardPatch.Mark patchMark : patch.getAddMarks()) {
                GameCard.Mark mark = new GameCard.Mark();
                mark.setId(UUID.randomUUID());
                mark.setTime(LocalTime.parse(patchMark.getTime(), DateTimeFormatter.ofPattern("HH:mm")));
                mark.setValue(Double.parseDouble(patchMark.getValue()));
                gameCard.getMarks().add(mark);
            }
        }
    }

}
