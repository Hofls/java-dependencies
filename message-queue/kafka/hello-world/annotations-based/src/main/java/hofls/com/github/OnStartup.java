package hofls.com.github;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class OnStartup {

    @Autowired
    private KafkaProducer kafkaProducer;

    @EventListener(ApplicationReadyEvent.class)
    public void sendMessageOnStartup() throws InterruptedException {
        kafkaProducer.sendMessage(new KafkaMessage("Hello Kafka!", UUID.randomUUID()));
    }
}