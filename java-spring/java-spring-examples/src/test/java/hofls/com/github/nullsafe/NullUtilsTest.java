package hofls.com.github.nullsafe;

import hofls.com.github.nullsafe.types.Area;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    void testSafeArray() {
        String arr[] = {};
        String actual = safe(() -> arr[0]);
        assertEquals(null, actual);
    }

    @Test
    void testSafeList() {
        List<String> list = new ArrayList<>();
        String actual = safe(() -> list.get(0));
        assertEquals(null, actual);
    }

    @Test
    void testSafeCycle() {
        List<String> list = null;
        for (String elem : safe(list)) {
            System.out.println(elem);
        }
    }
}
