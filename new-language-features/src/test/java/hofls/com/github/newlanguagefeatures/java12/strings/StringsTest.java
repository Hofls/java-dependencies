package hofls.com.github.newlanguagefeatures.java12.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringsTest {

    @Test
    void testIndent() {
        String expected =
                "   Hey\n"+
                "   Ho\n";
        String result = Strings.indent();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testTransform() {
        String result = Strings.transform();
        Assertions.assertEquals("HELLO WORLD", result);
    }
}
