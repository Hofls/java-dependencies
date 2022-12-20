package hofls.com.github.redis.purchase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.stereotype.Component;

@Component
public class PurchaseSubscriber implements MessageListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseSubscriber.class);

    @Override
    public void onMessage(Message message, byte[] pattern) {
        LOGGER.info("Received purchase - " + message);
    }

    public PatternTopic getTopic() {
        return new PatternTopic("purchase");
    }

}
