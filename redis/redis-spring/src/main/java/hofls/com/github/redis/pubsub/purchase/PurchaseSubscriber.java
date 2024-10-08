package hofls.com.github.redis.pubsub.purchase;

import hofls.com.github.utils.JsonConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class PurchaseSubscriber implements MessageListener {

    @Value("${redis.topic.purchase}")
    private String topic;

    private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseSubscriber.class);

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String json = new String(message.getBody(), StandardCharsets.UTF_8);
        Purchase purchase = JsonConverter.jsonToObject(json, Purchase.class);

        LOGGER.info("Received purchase - " + message);
        LOGGER.info("Received purchase converted to object - " + purchase);
    }

    public PatternTopic getTopic() {
        return new PatternTopic(topic);
    }

}
