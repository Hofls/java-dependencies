package hofls.com.github.rest.api.patch.service;

import hofls.com.github.rest.api.patch.dto.GameCard;
import hofls.com.github.rest.api.patch.dto.GameCardPatch;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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
    }

}
