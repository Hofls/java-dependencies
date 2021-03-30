package hofls.com.github.nullsafe;

import hofls.com.github.nullsafe.types.Area;
import org.junit.jupiter.api.Test;

import static hofls.com.github.nullsafe.NullUtils.safe;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NullUtilsTest {

    @Test
    void testSafe1() {
        Area area = null;
        String actual = safe(() -> area.getName(), "default");
        assertEquals("default", actual);
    }

    @Test
    void testSafe2() {
        Area area = null;
        String actual = safe(() -> area.getName());
        assertEquals(null, actual);
    }
}
