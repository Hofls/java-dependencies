package com.github.hofls.redis;

import com.github.hofls.redis.pubsub.logout.LogoutSubscriber;
import com.github.hofls.redis.pubsub.purchase.PurchaseSubscriber;
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
