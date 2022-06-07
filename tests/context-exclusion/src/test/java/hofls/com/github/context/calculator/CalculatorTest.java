package hofls.com.github.context.calculator;

import hofls.com.github.context.calculator.Calculator;
import hofls.com.github.context.common.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest extends BaseTest {
    Calculator calculator = new Calculator();

    @Test
    void should_add_two_numbers() {
        Assertions.assertEquals(5, calculator.add(2, 3));
    }
}

