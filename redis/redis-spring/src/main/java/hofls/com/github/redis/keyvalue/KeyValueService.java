package hofls.com.github.redis.keyvalue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class KeyValueService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(KeyValueService.class);

    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
        LOGGER.info("Set value - " + value);
    }

    public String get(String key) {
        String value = (String) redisTemplate.opsForValue().get(key);
        LOGGER.info("Get value - " + value);
        return value;
    }
}
