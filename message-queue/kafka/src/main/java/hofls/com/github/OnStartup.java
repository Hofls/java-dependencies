package hofls.com.github;

import lombok.val;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;
import java.util.UUID;

@Component
public class OnStartup {

    private final String SERVER_WITH_PORT = "localhost:9092";
    private final String TOPIC = "quickstart-topic";

    @EventListener(ApplicationReadyEvent.class) // or @PostConstruct
    public void doSomethingAfterStartup() {
        val consumer = createConsumer();
        writeMessage();
        readMessage(consumer);
    }

    private void writeMessage() {
        val props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, SERVER_WITH_PORT);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        val producer = new KafkaProducer<String, String>(props);
        producer.send(new ProducerRecord<>(TOPIC, "Message from client!"));
    }

    private KafkaConsumer<String, String> createConsumer() {
        val props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, SERVER_WITH_PORT);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, UUID.randomUUID().toString());
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        val consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Collections.singletonList(TOPIC));
        consumer.poll(1000);
        return consumer;
    }

    private void readMessage(KafkaConsumer<String, String> consumer) {
        val consumerRecords = consumer.poll(1000);
        System.out.println("Consumed count - " + consumerRecords.count());
        val firstMessage = consumerRecords.iterator().next().value();
        System.out.println("Consumed message - " + firstMessage);
    }


}
