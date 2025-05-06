package hofls.com.github;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
public class OnStartup {

    @Autowired
    private KafkaProducer kafkaProducer;

    @EventListener(ApplicationReadyEvent.class)
    public void sendMessageOnStartup() {
        kafkaProducer.sendMessage("Hello Kafka!");
    }
}