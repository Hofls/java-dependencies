package hofls.com.github.hello.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageListener {

    public List<String> messages = new ArrayList<>();

    @RabbitListener(queues = RabbitMQConfig.QUEUE_1)
    public void receiveMessage(String message) {
        messages.add(message);
        System.out.println("Received message: " + message);
    }
}
