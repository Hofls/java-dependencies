package hofls.com.github;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitReceiver {

    @RabbitListener(queues = "hello-queue")
    public void receive(String message) {
        System.out.println("Received message: " + message);
    }
}
