package hofls.com.github.context;

import hofls.com.github.context.need.a.mock.BrokenKafka;
import hofls.com.github.context.need.a.mock.BrokenRedis;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication //(exclude = {LiquibaseAutoConfiguration.class, CouchbaseAutoConfiguration.class})
// ^ Exclude auto-configuration classes https://docs.spring.io/spring-boot/docs/current/reference/html/auto-configuration-classes.html

// Without this line, error appears:
// Error creating bean with name 'brokenController': Unsatisfied dependency expressed through field 'service'
@ComponentScan(
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern={"hofls.com.github.context.exclude.from.tests.*", "some.other.package"}) })

// FilterType.REGEX hides hundreds of classes, but there is a couple of classes that you need? No problem, just import them:
// @Import({UserRepository.class, JacksonConfig.class})

// Alternative to FilterType.REGEX:
// @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = {RandomComponent.class, RandomRepository.class})

// There is too much to remove from context? Use "useDefaultFilters = false", and only include necessary classes

@MockBeans({@MockBean(BrokenKafka.class), @MockBean(BrokenRedis.class)})
// You can use @Autowired to get mocked bean, then specify behavior - when(kafka.count(any()).thenReturn(734);

public class TestApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}
