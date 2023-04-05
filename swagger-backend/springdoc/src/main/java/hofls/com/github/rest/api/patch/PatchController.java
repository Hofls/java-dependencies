package hofls.com.github.rest.api.patch;

import hofls.com.github.rest.api.patch.game.card.dto.GameCard;
import hofls.com.github.rest.api.patch.game.card.dto.GameCardPatch;
import hofls.com.github.rest.api.patch.game.card.service.GameCardService;
import hofls.com.github.rest.api.patch.school.dto.School;
import hofls.com.github.rest.api.patch.school.dto.SchoolPatch;
import hofls.com.github.rest.api.patch.school.service.SchoolService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
Rules for basic fields:
"John" - means user changed field value
"" - means user erased field value
null - means nothing changed

Rules for complex lists:
operation ADD - user added new mark
operation REPLACE - user changed old mark
operation REMOVE - user deleted old mark
all marks are empty/null - user changed nothing
 */

@Tag(name = "patch-controller", description = "HTTP PATCH example")
@RequestMapping("/patch-card")
@RestController
public class PatchController {

    @Autowired
    private GameCardService gameService;
    public static GameCard gameCard = new GameCard();

    @Autowired
    private SchoolService schoolService;
    public static School school = new School();

    @Operation(summary = "Patch card")
    @PatchMapping("/card")
    public GameCard patchCard(@RequestBody GameCardPatch patch) {
        gameService.applyPatch(gameCard, patch);
        return gameCard;
    }

    @Operation(summary = "Get card")
    @GetMapping("/card")
    public GameCard getCard() {
        return gameCard;
    }

    @Operation(summary = "Patch school")
    @PatchMapping("/school")
    public School patchSchool(@RequestBody SchoolPatch patch) {
        schoolService.applyPatch(school, patch);
        return school;
    }

    @Operation(summary = "Get school")
    @GetMapping("/school")
    public School getSchool() {
        return school;
    }




}
