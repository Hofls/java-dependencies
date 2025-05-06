package hofls.com.github;

import java.util.UUID;

public class KafkaMessage {

    private String greeting;
    private UUID id;

    public KafkaMessage() {
    }

    public KafkaMessage(String greeting, UUID id) {
        this.greeting = greeting;
        this.id = id;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return JsonConverter.objectToJson(this);
    }
}
