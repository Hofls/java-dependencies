package hofls.com.github.validation;

import jakarta.validation.Valid; // it used to be "javax.validation.Valid"
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;


@Validated // Activates the Spring Validation AOP interceptor. Interceptor will examine method parameters to see if they have any validation annotations
@Component
public class AutoValidator {


    // @Valid works only if method is called from another class, because of proxy "wrapper" (same as any other annotation)
    public String getGreeting(@Valid ObjectToValidate obj) {
        return "Hey";
    }

    public String greetByName(@NotNull String name) {
        return "Hey, " + name;
    }

}
