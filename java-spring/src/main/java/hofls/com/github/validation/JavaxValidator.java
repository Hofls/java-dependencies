package hofls.com.github.validation;

import org.springframework.validation.annotation.Validated;

import javax.validation.*;
import java.util.Set;

@Validated
public class JavaxValidator {

    public static void validate(ObjectToValidate obj) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<ObjectToValidate>> violations = validator.validate(obj);
        for (ConstraintViolation<ObjectToValidate> violation : violations) {
            throw new IllegalArgumentException(violation.getPropertyPath().toString() + " - " + violation.getMessageTemplate());
        }
    }

}
