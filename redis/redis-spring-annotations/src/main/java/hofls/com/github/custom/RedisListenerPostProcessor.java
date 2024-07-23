package hofls.com.github.custom;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
public class RedisListenerPostProcessor implements BeanPostProcessor {

    @Autowired
    private RedisMessageListenerContainer redisMessageListenerContainer;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(RedisListener.class)) {
            RedisListener redisListener = bean.getClass().getAnnotation(RedisListener.class);
            String topic = redisListener.topic();

            redisMessageListenerContainer.addMessageListener(new MessageListenerAdapter(bean), new PatternTopic(topic));
        }
        return bean;
    }


}
