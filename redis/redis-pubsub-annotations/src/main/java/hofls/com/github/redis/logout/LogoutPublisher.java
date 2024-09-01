
package hofls.com.github.redis.logout;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class LogoutPublisher {

    @Value("${redis.topic.logout}")
    private String topic;

    private static final Logger LOGGER = LoggerFactory.getLogger(LogoutPublisher.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void publishMessage() {
        LOGGER.info("Publishing logout message");
        redisTemplate.convertAndSend(topic, "{userId: 7261}");
    }

}