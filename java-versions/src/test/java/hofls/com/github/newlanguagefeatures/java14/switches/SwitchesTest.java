package hofls.com.github.newlanguagefeatures.java14.switches;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SwitchesTest {
    Switches switches = new Switches();

    @Test
    void testProduceNumber() {
        Assertions.assertEquals(1, switches.produceNumber("a"));
        Assertions.assertEquals(3, switches.produceNumber("c"));
        Assertions.assertEquals(0, switches.produceNumber("nope"));
    }
}
