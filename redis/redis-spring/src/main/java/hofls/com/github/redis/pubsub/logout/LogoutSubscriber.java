package hofls.com.github.redis.pubsub.logout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.stereotype.Component;

@Component
public class LogoutSubscriber implements MessageListener {

    @Value("${redis.topic.logout}")
    private String topic;

    private static final Logger LOGGER = LoggerFactory.getLogger(LogoutSubscriber.class);

    @Override
    public void onMessage(Message message, byte[] pattern) {
        LOGGER.info("Received logout - " + message);
    }

    public PatternTopic getTopic() {
        return new PatternTopic(topic);
    }

}
