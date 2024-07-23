package hofls.com.github.redis.purchase;

import hofls.com.github.custom.RedisListener;
import hofls.com.github.utils.JsonConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@RedisListener(topic = "purchase-topic")
public class PurchaseSubscriber implements MessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseSubscriber.class);

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String json = new String(message.getBody(), StandardCharsets.UTF_8);
        Purchase purchase = JsonConverter.jsonToObject(json, Purchase.class);

        LOGGER.info("Received purchase - " + message);
        LOGGER.info("Received purchase converted to object - " + purchase);
    }

}
