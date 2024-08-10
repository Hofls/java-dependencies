package hofls.com.github.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;

// TODO - fix (only validates top level, no composite classes)
public class ManualValidator {

    public static void validate(ObjectToValidate obj) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<ObjectToValidate>> violations = validator.validate(obj);
        for (ConstraintViolation<ObjectToValidate> violation : violations) {
            String objectName = violation.getRootBeanClass().getSimpleName();
            String propertyName = violation.getPropertyPath().toString();
            throw new IllegalArgumentException(objectName + "." + propertyName + ": " + violation.getMessage());
        }
    }

}
