package hofls.com.github.rest.api.patch;

import com.github.hofls.test.utils.TestUtils;
import hofls.com.github.Application;
import hofls.com.github.rest.api.patch.game.card.dto.GameCard;
import hofls.com.github.rest.api.patch.game.card.dto.GameCardPatch;
import hofls.com.github.rest.api.patch.school.dto.School;
import hofls.com.github.rest.api.patch.school.dto.SchoolPatch;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;



@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
class PatchControllerTest {

    @Autowired
    private PatchController patchController;

    @Test
    void patchCard() throws Exception {
        // Add
        GameCardPatch patchAdd = TestUtils.readObjectFromFile(
                this.getClass(), "patchCard_add_request.json", GameCardPatch.class);
        GameCard actualAdded = patchController.patchCard(patchAdd);
        String expectedAdded = TestUtils.readFile(this.getClass(), "patchCard_add_result.json");
        TestUtils.assertEqualJson(expectedAdded, actualAdded);

        // Nothing changes


        // Replace everything
        GameCardPatch patchReplace = TestUtils.readObjectFromFile(
                this.getClass(), "patchCard_replace_request.json", GameCardPatch.class);
        GameCard actualReplace = patchController.patchCard(patchReplace);
        String expectedReplace = TestUtils.readFile(this.getClass(), "patchCard_replace_result.json");
        TestUtils.assertEqualJson(expectedReplace, actualReplace);

        // Remove everything
        GameCardPatch patchRemove = TestUtils.readObjectFromFile(
                this.getClass(), "patchCard_remove_request.json", GameCardPatch.class);
        GameCard actualRemove = patchController.patchCard(patchRemove);
        String expectedRemove = TestUtils.readFile(this.getClass(), "patchCard_remove_result.json");
        TestUtils.assertEqualJson(expectedRemove, actualRemove);
    }

    @Test
    void patchSchool() throws Exception {
        // Add
        SchoolPatch patchAdd = TestUtils.readObjectFromFile(
                this.getClass(), "patchSchool_add_request.json", SchoolPatch.class);
        School actualAdded = patchController.patchSchool(patchAdd);
        String expectedAdded = TestUtils.readFile(this.getClass(), "patchSchool_add_result.json");
        TestUtils.assertEqualJson(expectedAdded, actualAdded);

        // Nothing changes
        SchoolPatch patchNothing = TestUtils.readObjectFromFile(
                this.getClass(), "patchSchool_nothing_request.json", SchoolPatch.class);
        School actualNothing = patchController.patchSchool(patchNothing);
        String expectedNothing = TestUtils.readFile(this.getClass(), "patchSchool_nothing_result.json");
        TestUtils.assertEqualJson(expectedNothing, actualNothing);

        // Replace everything
        SchoolPatch patchReplace = TestUtils.readObjectFromFile(
                this.getClass(), "patchSchool_replace_request.json", SchoolPatch.class);
        School actualReplace = patchController.patchSchool(patchReplace);
        String expectedReplace = TestUtils.readFile(this.getClass(), "patchSchool_replace_result.json");
        TestUtils.assertEqualJson(expectedReplace, actualReplace);

        // Remove everything
        SchoolPatch patchRemove = TestUtils.readObjectFromFile(
                this.getClass(), "patchSchool_remove_request.json", SchoolPatch.class);
        School actualRemove = patchController.patchSchool(patchRemove);
        String expectedRemove = TestUtils.readFile(this.getClass(), "patchSchool_remove_result.json");
        TestUtils.assertEqualJson(expectedRemove, actualRemove);
    }

}
