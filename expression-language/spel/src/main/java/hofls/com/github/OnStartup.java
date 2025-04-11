package hofls.com.github;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;


@Component
public class OnStartup {

    @EventListener(ApplicationReadyEvent.class) // or @PostConstruct
    public void doSomethingAfterStartup()  {
        System.out.println("SpEL expression result 1 - " + evaluateSpelExpression(22, 74));
        System.out.println("SpEL expression result 2 - " + evaluateSpelExpression(240, 12));
        System.out.println("SpEL expression result 3 - " + evaluateSpelExpression(44, 250));
    }

    // Use case example - bunch of formulas/conditions are constantly changing + stored in database
    public boolean evaluateSpelExpression(int scg, int bpWys) {
        String expressionString = "#SCG > 150 or (#BP_WYS >= 55 and #BP_WYS <= 95)";
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression(expressionString);

        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("SCG", scg);
        context.setVariable("BP_WYS", bpWys);

        return expression.getValue(context, Boolean.class);
    }


}
