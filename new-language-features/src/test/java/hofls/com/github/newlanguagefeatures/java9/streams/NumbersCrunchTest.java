package hofls.com.github.newlanguagefeatures.java9.streams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class NumbersCrunchTest {

    @Test
    void testTakeWhile() {
        List<Integer> result = NumbersCrunch.takeWhile();
        Assertions.assertEquals(Arrays.asList(1, 2), result);
    }

    @Test
    void testDropWhile() {
        List<Integer> result = NumbersCrunch.dropWhile();
        Assertions.assertEquals(Arrays.asList(5, 4, 3), result);
    }

    @Test
    void testIterate() {
        List<Integer> result = NumbersCrunch.iterate();
        Assertions.assertEquals(Arrays.asList(0, 1, 2), result);
    }


}