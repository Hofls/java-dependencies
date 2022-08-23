package hofls.com.github;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class InventoryController {

    @Autowired
    private RestTemplate restTemplate;

    private static Logger log = LoggerFactory.getLogger(InventoryController.class);

    @RequestMapping("/inventory-endpoint")
    public String inventoryDemo() {
        log.info("Inventory demo");
        return restTemplate.getForObject("https://en0jrwaokozja4.x.pipedream.net/", String.class);
    }

    /** RestTemplate must be in application context (to inject traceId and spanId) */
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
