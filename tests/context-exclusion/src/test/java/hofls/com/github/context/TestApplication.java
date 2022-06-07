package hofls.com.github.context;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication

// Without this line, error appears:
// Error creating bean with name 'brokenController': Unsatisfied dependency expressed through field 'service'
@ComponentScan(
        excludeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.REGEX, pattern="hofls.com.github.context.dependency.*") })



public class TestApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}
