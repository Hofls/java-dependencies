
package hofls.com.github.redis.purchase;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class PurchasePublisher {

    private static final Logger LOGGER = LoggerFactory.getLogger(PurchasePublisher.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void publishMessage() {
        LOGGER.info("Publishing purchase message");
        redisTemplate.convertAndSend("purchase", "{id: 874, price:20}");
    }

}