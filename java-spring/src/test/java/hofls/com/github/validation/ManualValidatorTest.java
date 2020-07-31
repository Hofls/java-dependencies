package hofls.com.github.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ManualValidatorTest {

    @BeforeAll
    public static void setLocale() {
        Locale.setDefault(Locale.US);
    }

    @Test
    void testValidateA() {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            ObjectToValidate objectToValidate = new ObjectToValidate();
            objectToValidate.setFieldB(123L);
            ManualValidator.validate(objectToValidate);
        });
        assertEquals("ObjectToValidate.fieldA: must not be empty", exception.getMessage());
    }

    @Test
    void testValidateB() {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            ObjectToValidate objectToValidate = new ObjectToValidate();
            objectToValidate.setFieldA("hey");
            objectToValidate.setFieldB(23L);
            ManualValidator.validate(objectToValidate);
        });
        assertEquals("ObjectToValidate.fieldB: must be greater than or equal to 55", exception.getMessage());

    }

}
