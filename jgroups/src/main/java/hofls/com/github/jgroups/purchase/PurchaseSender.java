package hofls.com.github.jgroups.purchase;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PurchaseSender {

    @Autowired
    private JChannel channel;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void sendMessage(String message) throws Exception {
        logger.info("Send message '{}'", message);
        Message msg = new Message(null, message);
        channel.send(msg);
    }

}
