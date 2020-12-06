package hofls.com.github;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VerbalTest {

    @Test
    void isUrlTest() {
        Assertions.assertFalse(Verbal.isUrl("not a url"));
        Assertions.assertTrue(Verbal.isUrl("https://example.com"));
    }
}
