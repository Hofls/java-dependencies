package hofls.com.github.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class AutoValidatorTest {

    @Autowired private AutoValidator autoValidator;

    @BeforeAll
    public static void setLocale() {
        Locale.setDefault(Locale.US);
    }

    @Test
    void testValidateA() {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            ObjectToValidate objectToValidate = new ObjectToValidate();
            objectToValidate.setFieldB(123L);
            autoValidator.getGreeting(objectToValidate);
        });
        assertEquals("getGreeting.obj.fieldA: must not be empty", exception.getMessage());
    }

    @Test
    void testValidateB() {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            ObjectToValidate objectToValidate = new ObjectToValidate();
            objectToValidate.setFieldA("hey");
            objectToValidate.setFieldB(23L);
            autoValidator.getGreeting(objectToValidate);
        });
        assertEquals("getGreeting.obj.fieldB: must be greater than or equal to 55", exception.getMessage());

    }
}

