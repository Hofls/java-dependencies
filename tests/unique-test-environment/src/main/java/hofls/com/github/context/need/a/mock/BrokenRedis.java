package hofls.com.github.context.need.a.mock;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BrokenRedis {

    @Value("${redis.config.ip}")
    private String ip;

    @Value("${redis.config.port}")
    private String port;

    @Value("${redis.config.login}")
    private String login;
}
