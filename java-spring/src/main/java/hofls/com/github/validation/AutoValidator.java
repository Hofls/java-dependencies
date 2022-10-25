package hofls.com.github.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated // Activates the Spring Validation AOP interceptor. Interceptor will examine method parameters to see if they have any validation annotations
@Component
public class AutoValidator {


    // @Valid works only if method is called from another class, because of proxy "wrapper" (same as any other annotation)
    public String getGreeting(@Valid ObjectToValidate obj) {
        return "Hey";
    }

}
