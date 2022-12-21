package hofls.com.github.jgroups.purchase;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PurchaseSender {

    @Autowired
    @Qualifier("PurchaseJChannel")
    private JChannel channel;

    public void sendMessage(Purchase purchase) {
        try {
            System.out.println("Send purchase event - " + purchase);
            channel.send(new Message(null, purchase));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
