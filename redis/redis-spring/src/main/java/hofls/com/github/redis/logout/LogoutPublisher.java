
package hofls.com.github.redis.logout;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class LogoutPublisher {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogoutPublisher.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void publishMessage() {
        LOGGER.info("Publishing logout message");
        redisTemplate.convertAndSend("logout", "{userId: 7261}");
    }

}