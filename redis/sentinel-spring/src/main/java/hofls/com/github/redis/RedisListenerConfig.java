package hofls.com.github.redis;

import hofls.com.github.redis.logout.LogoutSubscriber;
import hofls.com.github.redis.purchase.PurchaseSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

@Component
public class RedisListenerConfig {

    @Autowired
    private RedisConnectionFactory connectionFactory;

    @Autowired
    private PurchaseSubscriber purchase;

    @Autowired
    private LogoutSubscriber logout;

    @Bean
    RedisMessageListenerContainer container() {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);

        container.addMessageListener(new MessageListenerAdapter(purchase), purchase.getTopic());
        container.addMessageListener(new MessageListenerAdapter(logout), logout.getTopic());
        return container;
    }
}
