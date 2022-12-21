package hofls.com.github;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void should_add_two_numbers() {
        Assertions.assertEquals(5, calculator.add(2, 3));
    }
}

