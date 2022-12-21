package hofls.com.github.jgroups.purchase;

import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.springframework.stereotype.Component;

@Component
public class PurchaseReceiver extends ReceiverAdapter {

    @Override
    public void receive(Message msg) {
        System.out.println("received message from: " + msg.getSrc() + " with content: " + msg.getObject());
    }
}
