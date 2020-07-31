package hofls.com.github.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
@Component
public class AutoValidator {


    public String getGreeting(@Valid ObjectToValidate obj) {
        return "Hey";
    }

}
