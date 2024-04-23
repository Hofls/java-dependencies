package hofls.com.github.feign;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    /** Adds "System-source" header for each @FeignClient request */
    @Bean
    public RequestInterceptor headerInterceptor() {
        return template -> {
            template.header("System-source", "digital_shop_27");
        };
    }

}