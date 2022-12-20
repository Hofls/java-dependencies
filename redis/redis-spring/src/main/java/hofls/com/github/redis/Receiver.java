package hofls.com.github.redis;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import java.util.ArrayList;
import java.util.List;

public class Receiver implements MessageListener {

    public static List<String> messageList = new ArrayList<>();

    public void onMessage(Message message, byte[] pattern) {
        messageList.add(message.toString());
        System.out.println("Message received: " + message.toString());
    }

}
