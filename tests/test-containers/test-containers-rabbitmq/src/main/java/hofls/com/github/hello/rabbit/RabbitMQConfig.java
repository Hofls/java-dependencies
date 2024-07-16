package hofls.com.github.hello.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMQConfig {

    public final static String QUEUE_1 = "TestQueue1";
    public final static String QUEUE_2 = "TestQueue2";

    @Bean // creates Queue in RabbitMQ (if not exists)
    public Queue queue1() {
        return new Queue(QUEUE_1, false);
    }

    @Bean // creates Queue in RabbitMQ (if not exists)
    public Queue queue2() {
        return new Queue(QUEUE_2, false);
    }

    @Bean // optional
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }
}
