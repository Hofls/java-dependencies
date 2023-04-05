package hofls.com.github.rest.api.patch.service;

import hofls.com.github.rest.api.patch.dto.GameCard;
import org.springframework.stereotype.Service;

@Service
public class GameCardService {

    public void applyPatch(GameCard gameCard, GameCard patch) {
        if (patch.getName() != null) {
            gameCard.setName(patch.getName());
        }
        if (patch.getPoints() != null) {
            gameCard.setPoints(patch.getPoints());
        }
        if (patch.getDate() != null) {
            gameCard.setDate(patch.getDate());
        }
    }

}
