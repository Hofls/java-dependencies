package hofls.com.github.jgroups.purchase;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PurchaseSender {

    @Autowired
    @Qualifier("PurchaseJChannel")
    private JChannel channel;

    public void sendMessage(Purchase purchase) throws Exception {
        System.out.println("Send purchase event - " + purchase);
        channel.send(new Message(null, purchase));
    }

}
