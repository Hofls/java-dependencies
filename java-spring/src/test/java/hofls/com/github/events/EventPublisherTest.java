package hofls.com.github.events;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EventPublisherTest {

    @Autowired
    private EventPublisher publisher;

    @Autowired
    private CustomEventListener listener;

    @Test
    public void sendMessage() {
        publisher.sendMessage("Hello world!");
        assertEquals("Hello world!", listener.lastMessage);
    }

}
