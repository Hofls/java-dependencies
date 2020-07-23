package hofls.com.github.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JavaxValidatorTest {

    @Test
    void testValidateA() {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            ObjectToValidate objectToValidate = new ObjectToValidate();
            objectToValidate.setFieldB(123L);
            JavaxValidator.validate(objectToValidate);
        });
        assertEquals("fieldA - {javax.validation.constraints.NotEmpty.message}", exception.getMessage());
    }

    @Test
    void testValidateB() {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            ObjectToValidate objectToValidate = new ObjectToValidate();
            objectToValidate.setFieldA("hey");
            objectToValidate.setFieldB(23L);
            JavaxValidator.validate(objectToValidate);
        });
        assertEquals("fieldB - {javax.validation.constraints.Min.message}", exception.getMessage());

    }

}
