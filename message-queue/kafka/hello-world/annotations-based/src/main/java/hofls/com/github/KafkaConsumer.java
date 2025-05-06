package hofls.com.github;


import org.springframework.stereotype.Service;

import org.springframework.kafka.annotation.KafkaListener;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "demo-topic", groupId = "group-id")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
