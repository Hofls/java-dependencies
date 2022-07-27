package hofls.com.github.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated // Activates the Spring Validation AOP interceptor. Interceptor will examine method parameters to see if they have any validation annotations
@Component
public class AutoValidator {


    public String getGreeting(@Valid ObjectToValidate obj) {
        return "Hey";
    }

}
