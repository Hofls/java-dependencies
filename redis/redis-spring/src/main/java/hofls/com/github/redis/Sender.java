package hofls.com.github.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Sender {

    @Autowired
    private StringRedisTemplate redisTemplate;


    @PostConstruct
    public void init() throws Exception {
        sendMessage();
        Thread.sleep(500);
    }

    public void sendMessage() {
        redisTemplate.convertAndSend("chat", "Hello from Redis!");
    }

}
