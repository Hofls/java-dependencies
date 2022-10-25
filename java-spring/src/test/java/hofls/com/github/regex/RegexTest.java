package hofls.com.github.regex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegexTest {

    @Test
    void removeSpecialCharacters_BAD() throws Exception {
        var actual = Regex.removeSpecialCharacters_BAD( "Hello#мир!2");
        assertEquals("Hello_2", actual);
    }

    @Test
    void removeSpecialCharacters_GOOD() throws Exception {
        var actual = Regex.removeSpecialCharacters_GOOD( "Hello#мир!2");
        assertEquals("Hello_мир_2", actual);
    }

}