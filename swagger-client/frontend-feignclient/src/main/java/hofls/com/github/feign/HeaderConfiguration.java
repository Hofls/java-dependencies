package hofls.com.github.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Adds "System-source" header for each @FeignClient request
@Configuration
public class HeaderConfiguration {

    @Bean
    public HeaderInterceptor customFeignInterceptor() {
        return new HeaderInterceptor();
    }

    public static class HeaderInterceptor implements RequestInterceptor {
        @Override
        public void apply(RequestTemplate template) {
            template.header("System-source", "digital_shop_27");
        }
    }

}