package hofls.com.github.jgroups.purchase;

import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.springframework.stereotype.Component;

@Component
public class PurchaseReceiver extends ReceiverAdapter {

    @Override
    public void receive(Message msg) {
        Purchase purchase = msg.getObject();
        System.out.println("Received purchase from: " + msg.getSrc() + " with content: " + purchase);
    }
}
