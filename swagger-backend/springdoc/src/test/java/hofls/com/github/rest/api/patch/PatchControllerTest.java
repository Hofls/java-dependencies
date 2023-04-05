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
        String jsonAdd = TestUtils.readFile(this.getClass(), "patchCard_add_request.json");
        GameCardPatch patchAdd = TestUtils.jsonToObject(jsonAdd, GameCardPatch.class);
        GameCard actualAdded = patchController.patchCard(patchAdd);
        String expectedAdded = TestUtils.readFile(this.getClass(), "patchCard_add_result.json");
        TestUtils.assertEqualJson(expectedAdded, actualAdded, Arrays.asList("id"));

        // REPLACE

        // REMOVE

    }

}
