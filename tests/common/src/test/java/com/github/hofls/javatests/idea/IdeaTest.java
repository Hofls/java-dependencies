package com.github.hofls.javatests.idea;

import com.github.hofls.test.utils.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IdeaTest {

    @Test
    void compare_files_in_edit() throws Exception {
        String expected = TestUtils.readFile(this.getClass(), "compare_files_expected.txt");
        String actual = "def";

        IdeaUtils.toFile("compare_files_actual.txt", actual);
        assertEquals(expected, actual);
    }

}
