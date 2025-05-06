package hofls.com.github;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Value("${spring.kafka.topics.greetings}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(KafkaMessage message) {
        System.out.println("Sending message: " + message);
        kafkaTemplate.send(topic, JsonConverter.objectToJson(message));
    }
}
