package hofls.com.github.utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TextUtilsTest {

    @Test
    void testFirstNotEmpty() throws Exception {
        List<String> filledList =
                Arrays.asList(
                        null, "", " ", " ", " ", "​\u200B", "\n", "first", "", null, "second");
        List<String> emptyList = Arrays.asList(null, "", "", null);

        assertEquals("first", TextUtils.firstNotEmpty(filledList));
        assertEquals(null, TextUtils.firstNotEmpty(emptyList));
        assertEquals(null, TextUtils.firstNotEmpty(null));
    }

    @Test
    void isTrimmedEmpty()  throws Exception{
        assertTrue(TextUtils.isTrimmedEmpty("   \u200B   "));
        assertFalse(TextUtils.isTrimmedEmpty("   text\u200B   "));
    }
}