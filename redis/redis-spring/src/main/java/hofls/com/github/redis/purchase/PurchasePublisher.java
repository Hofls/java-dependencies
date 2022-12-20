
package hofls.com.github.redis.purchase;


import hofls.com.github.utils.JsonConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class PurchasePublisher {

    @Value("${redis.topic.purchase}")
    private String topic;

    private static final Logger LOGGER = LoggerFactory.getLogger(PurchasePublisher.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void publishMessage(Purchase purchase) {
        LOGGER.info("Publishing purchase message");
        String json = JsonConverter.objectToJson(purchase);
        redisTemplate.convertAndSend(topic, json);
    }

}