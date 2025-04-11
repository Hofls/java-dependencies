package hofls.com.github;

import org.mvel2.MVEL;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class OnStartup {

    @EventListener(ApplicationReadyEvent.class) // or @PostConstruct
    public void doSomethingAfterStartup()  {
        System.out.println("SpEL expression result 1 - " + evaluateMvelExpression(22, 74));
        System.out.println("SpEL expression result 2 - " + evaluateMvelExpression(240, 12));
        System.out.println("SpEL expression result 3 - " + evaluateMvelExpression(44, 250));
    }

    // Use case example - bunch of formulas/conditions are constantly changing + stored in database
    public boolean evaluateMvelExpression(int scg, int bpWys) {
        String expression = "SCG > 150 || (BP_WYS >= 55 && BP_WYS <= 95)";

        Map<String, Object> variables = new HashMap<>();
        variables.put("SCG", scg);
        variables.put("BP_WYS", bpWys);

        // Compile and execute the expression with the provided variables
        return (Boolean) MVEL.eval(expression, variables);
    }

}
