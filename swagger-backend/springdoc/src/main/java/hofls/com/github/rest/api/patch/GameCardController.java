package hofls.com.github.rest.api.patch;

import hofls.com.github.rest.api.patch.dto.GameCard;
import hofls.com.github.rest.api.patch.dto.GameCardPatch;
import hofls.com.github.rest.api.patch.service.GameCardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Basic patch rules:
 * "John" - means user changed field value
 * "" - means user erased field value
 * null - means nothing changed
 *
 * Complex list rules:
 * addMarks - means user added new mark
 * editMarks - means user changed old mark
 * deleteMarks - means user deleted old mark
 * all marks are empty/null - means nothing changed
 */

@Tag(name = "game-card-controller", description = "HTTP PATCH example")
@RequestMapping("/game-card")
@RestController
public class GameCardController {

    @Autowired
    private GameCardService service;

    public static GameCard gameCard = new GameCard();

    @Operation(summary = "Get card")
    @GetMapping
    public GameCard get() {
        return gameCard;
    }

    @Operation(summary = "Patch card")
    @PatchMapping
    public void patch(@RequestBody GameCardPatch patch) {
        service.applyPatch(gameCard, patch);
    }

}
