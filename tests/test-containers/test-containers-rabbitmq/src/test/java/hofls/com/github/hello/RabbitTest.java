package hofls.com.github.hello;

import hofls.com.github.hello.rabbit.MessageListener;
import hofls.com.github.hello.rabbit.MessageProducer;
import hofls.com.github.hello.rabbit.RabbitMQConfig;
import org.junit.Test;
import org.springframework.amqp.core.QueueInformation;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class RabbitTest extends BaseTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private MessageListener messageListener;

    @Autowired
    private MessageProducer messageProducer;

    @Autowired
    private RabbitAdmin rabbitAdmin;

    @Test
    public void rabbitTest1() throws Exception {
        messageProducer.sendMessage();
        Thread.sleep(100);
        assertEquals("Hello world!", messageListener.messages.get(0));
    }

    @Test
    public void rabbitTest2() {
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_2, "Test Message 2");
        String actual = (String) rabbitTemplate.receiveAndConvert(RabbitMQConfig.QUEUE_2);
        assertEquals("Test Message 2", actual);
    }

    @Test
    public void adminTest1() throws Exception {
        int count = rabbitAdmin.purgeQueue(RabbitMQConfig.QUEUE_1);
        assertEquals(0, count);
    }

}
