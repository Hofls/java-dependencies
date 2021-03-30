package hofls.com.github.nullsafe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NullUtilsTest {

    @Test
    void testSafe1() {
        String actual = NullUtils.safe(() -> { throw new NullPointerException(); }, "default");
        assertEquals("default", actual);
    }

    @Test
    void testSafe2() {
        String actual = NullUtils.safe(() -> { throw new NullPointerException(); });
        assertEquals(null, actual);
    }
}
