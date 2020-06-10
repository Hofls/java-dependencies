package hofls.com.github.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConcatenationDemoTest {

    @Test
    void testConcatenateA() {
        String result = ConcatenationDemo.concatenateA("John", "Chicago");
        Assertions.assertEquals("Hello John, are you from Chicago?", result);
    }

    @Test
    void testConcatenateA_nulls() {
        String result = ConcatenationDemo.concatenateA(null, null);
        Assertions.assertEquals("Hello null, are you from null?", result);
    }

    @Test
    void testConcatenateB() {
        String actual = ConcatenationDemo.concatenateB("Peter", "London");
        String expected = "Known info:\n" +
                "User name - Peter\n" +
                "Visited city - London";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void testConcatenateB_nulls() {
        String actual = ConcatenationDemo.concatenateB(null, null);
        String expected = "Known info:";
        Assertions.assertEquals(expected, actual);
    }
}
