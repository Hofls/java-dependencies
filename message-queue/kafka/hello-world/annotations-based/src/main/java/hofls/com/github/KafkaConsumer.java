package hofls.com.github;


import org.springframework.stereotype.Service;

import org.springframework.kafka.annotation.KafkaListener;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "${spring.kafka.topics.greetings}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(String messageRaw) {
        var message = JsonConverter.jsonToObject(messageRaw, KafkaMessage.class);
        System.out.println("Received message: " + message);
    }
}
