package hofls.com.github.context.calculator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Calculator {

    @Value("${common-property:}")
    String commonProperty;

}
