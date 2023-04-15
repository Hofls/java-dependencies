package hofls.com.github.rest.patch;

import com.github.hofls.test.utils.TestUtils;
import hofls.com.github.Application;
import hofls.com.github.rest.patch.game.dto.Game;
import hofls.com.github.rest.patch.game.dto.GamePatch;
import hofls.com.github.rest.patch.school.dto.School;
import hofls.com.github.rest.patch.school.dto.SchoolPatch;
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
        // Fill all fields
        GamePatch patchAdd = TestUtils.readObjectFromFile(
                this.getClass(), "game_add_request.json", GamePatch.class);
        Game actualAdded = patchController.patchCard(patchAdd);
        String expectedAdded = TestUtils.readFile(this.getClass(), "game_add_result.json");
        TestUtils.assertEqualJson(expectedAdded, actualAdded);

        // Partial changes (only specified fields change, other fields stay the same)
        GamePatch patchPartial = TestUtils.readObjectFromFile(
                this.getClass(), "game_partial_request.json", GamePatch.class);
        Game actualPart = patchController.patchCard(patchPartial);
        String expectedPart = TestUtils.readFile(this.getClass(), "game_partial_result.json");
        TestUtils.assertEqualJson(expectedPart, actualPart);

        // Remove everything
        GamePatch patchRemove = TestUtils.readObjectFromFile(
                this.getClass(), "game_remove_request.json", GamePatch.class);
        Game actualRemove = patchController.patchCard(patchRemove);
        String expectedRemove = TestUtils.readFile(this.getClass(), "game_remove_result.json");
        TestUtils.assertEqualJson(expectedRemove, actualRemove);
    }

    @Test // Short
    void patchSchool() throws Exception {
        // Fill all fields
        SchoolPatch patchAdd = TestUtils.readObjectFromFile(
                this.getClass(), "patchSchool_add_request.json", SchoolPatch.class);
        School actualAdded = patchController.patchSchool(patchAdd);
        String expectedAdded = TestUtils.readFile(this.getClass(), "patchSchool_add_result.json");
        TestUtils.assertEqualJson(expectedAdded, actualAdded);

        // Partial changes (only specified fields change, other fields stay the same)
        SchoolPatch patchPartial = TestUtils.readObjectFromFile(
                this.getClass(), "patchSchool_partial_request.json", SchoolPatch.class);
        School actualPart = patchController.patchSchool(patchPartial);
        String expectedPart = TestUtils.readFile(this.getClass(), "patchSchool_partial_result.json");
        TestUtils.assertEqualJson(expectedPart, actualPart);

        // Remove everything
        SchoolPatch patchRemove = TestUtils.readObjectFromFile(
                this.getClass(), "patchSchool_remove_request.json", SchoolPatch.class);
        School actualRemove = patchController.patchSchool(patchRemove);
        String expectedRemove = TestUtils.readFile(this.getClass(), "patchSchool_remove_result.json");
        TestUtils.assertEqualJson(expectedRemove, actualRemove);
    }

}
