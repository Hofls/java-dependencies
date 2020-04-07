package hofls.com.github.aspect;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
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
        Assert.assertEquals(expectedException.getMessage(), actualException.getMessage());
    }

}
