package hofls.com.github.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// There is an (outdated) alternative - project "xml-config-beans"
@Configuration
public class BeanDemo {

    @Bean // adds bean to application context (e.g. use it via @Autowired)
    ServiceApi rir2RouteServiceApi() {
        return new ServiceApi();
    }

    public static class ServiceApi {}

}
