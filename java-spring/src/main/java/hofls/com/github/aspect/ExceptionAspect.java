package hofls.com.github.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class ExceptionAspect {

    List<Exception> thrownExceptions = new ArrayList<>();

    @AfterThrowing(pointcut  = "execution(* hofls.com.github.aspect..*(..))", throwing = "exception")
    public void afterThrowingAdvice(JoinPoint joinPoint, Exception exception) {
        thrownExceptions.add(exception);
    }

    @Before("execution(* hofls.com.github.aspect..*(..))")
    public void beforeExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Before " + methodName + " execution");
    }

}
