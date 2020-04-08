package hofls.com.github.aspect;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ExceptionAspectTest {

    @Autowired
    ExceptionAspect exceptionAspect;

    @Autowired
    SalaryCalculator salaryCalculator;

    @Test
    public void aspect_should_add_exception_to_the_list() {
        try {
            salaryCalculator.calculateSalary();
        } catch (Exception e) {}

        UnsupportedOperationException expectedException = new UnsupportedOperationException("Not implemented yet");
        Exception actualException = exceptionAspect.thrownExceptions.get(0);
        assertEquals(expectedException.getMessage(), actualException.getMessage());
    }

}
