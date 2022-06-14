package hofls.com.github.context.need.a.mock;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BrokenKafka {

    @Value("${kafka.config.ip}")
    private String ip;

    @Value("${kafka.config.port}")
    private String port;

    @Value("${kafka.config.login}")
    private String login;
}
