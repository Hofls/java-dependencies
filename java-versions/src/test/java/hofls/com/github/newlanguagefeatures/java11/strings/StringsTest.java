package hofls.com.github.newlanguagefeatures.java11.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class StringsTest {

    @Test
    void testRepeat() {
        String result = Strings.repeat();
        Assertions.assertEquals("Ho Ho Ho ", result);
    }

    @Test
    void testLines() {
        var expected = Arrays.asList("first_line", "second_line");
        Assertions.assertEquals(expected, Strings.lines());
    }
}
