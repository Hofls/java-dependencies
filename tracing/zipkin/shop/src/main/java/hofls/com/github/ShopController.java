package hofls.com.github;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ShopController {

    @Autowired
    private RestTemplate restTemplate;

    private static Logger log = LoggerFactory.getLogger(ShopController.class);

    @RequestMapping("/shop-endpoint")
    public String shopDemo() {
        log.info("Shop demo");
        return restTemplate.getForObject("http://localhost:8082/inventory-endpoint", String.class);
    }

    /** RestTemplate must be in application context (to inject traceId and spanId) */
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
