package hofls.com.github.context.calculator;

import hofls.com.github.context.common.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class CalculatorTest extends BaseTest {
    @Autowired Calculator calculator;

    @Test
    void applicationYmlShouldBeOverridden() {
        Assertions.assertEquals("", calculator.commonProperty);
    }
}

