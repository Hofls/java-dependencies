package hofls.com.github.rest.api.patch;

import com.github.hofls.test.utils.TestUtils;
import hofls.com.github.Application;
import hofls.com.github.rest.api.patch.game.card.dto.GameCard;
import hofls.com.github.rest.api.patch.game.card.dto.GameCardPatch;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
class PatchControllerTest {

    @Autowired
    private PatchController patchController;

    @Test
    void patchCard() throws Exception {
        // ADD
        GameCardPatch patchAdd = TestUtils.readObjectFromFile(
                this.getClass(), "patchCard_add_request.json", GameCardPatch.class);
        GameCard actualAdded = patchController.patchCard(patchAdd);
        String expectedAdded = TestUtils.readFile(this.getClass(), "patchCard_add_result.json");
        TestUtils.assertEqualJson(expectedAdded, actualAdded);

        // REPLACE
        GameCardPatch patchReplace = TestUtils.readObjectFromFile(
                this.getClass(), "patchCard_replace_request.json", GameCardPatch.class);
        GameCard actualReplace = patchController.patchCard(patchReplace);
        String expectedReplace = TestUtils.readFile(this.getClass(), "patchCard_replace_result.json");
        TestUtils.assertEqualJson(expectedReplace, actualReplace);

        // REMOVE
        GameCardPatch patchRemove = TestUtils.readObjectFromFile(
                this.getClass(), "patchCard_remove_request.json", GameCardPatch.class);
        GameCard actualRemove = patchController.patchCard(patchRemove);
        String expectedRemove = TestUtils.readFile(this.getClass(), "patchCard_remove_result.json");
        TestUtils.assertEqualJson(expectedRemove, actualRemove);

    }

}
