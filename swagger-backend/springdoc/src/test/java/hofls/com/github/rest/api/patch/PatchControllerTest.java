package hofls.com.github.rest.api.patch;

import com.github.hofls.test.utils.TestUtils;
import hofls.com.github.Application;
import hofls.com.github.rest.api.patch.game.dto.Game;
import hofls.com.github.rest.api.patch.game.dto.GamePatch;
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

    @Test // Full
    void patchCard() throws Exception {
        // Add
        GamePatch patchAdd = TestUtils.readObjectFromFile(
                this.getClass(), "patchCard_add_request.json", GamePatch.class);
        Game actualAdded = patchController.patchCard(patchAdd);
        String expectedAdded = TestUtils.readFile(this.getClass(), "patchCard_add_result.json");
        TestUtils.assertEqualJson(expectedAdded, actualAdded);

        // Nothing changes
        GamePatch patchNothing = TestUtils.readObjectFromFile(
                this.getClass(), "patchCard_nothing_request.json", GamePatch.class);
        Game actualNothing = patchController.patchCard(patchNothing);
        String expectedNothing = TestUtils.readFile(this.getClass(), "patchCard_nothing_result.json");
        TestUtils.assertEqualJson(expectedNothing, actualNothing);

        // Replace everything
        GamePatch patchReplace = TestUtils.readObjectFromFile(
                this.getClass(), "patchCard_replace_request.json", GamePatch.class);
        Game actualReplace = patchController.patchCard(patchReplace);
        String expectedReplace = TestUtils.readFile(this.getClass(), "patchCard_replace_result.json");
        TestUtils.assertEqualJson(expectedReplace, actualReplace);

        // Clear half of mark values (another half stays the same)
        GamePatch patchMarks = TestUtils.readObjectFromFile(
                this.getClass(), "patchCard_marks_request.json", GamePatch.class);
        Game actualMarks = patchController.patchCard(patchMarks);
        String expectedMarks = TestUtils.readFile(this.getClass(), "patchCard_marks_result.json");
        TestUtils.assertEqualJson(expectedMarks, actualMarks);

        // Remove everything
        GamePatch patchRemove = TestUtils.readObjectFromFile(
                this.getClass(), "patchCard_remove_request.json", GamePatch.class);
        Game actualRemove = patchController.patchCard(patchRemove);
        String expectedRemove = TestUtils.readFile(this.getClass(), "patchCard_remove_result.json");
        TestUtils.assertEqualJson(expectedRemove, actualRemove);
    }

    @Test // Short
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
