package com.github.hofls.jgroups.logout;

import com.github.hofls.jgroups.purchase.Purchase;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.springframework.stereotype.Component;

@Component
public class LogoutReceiver extends ReceiverAdapter {

    @Override
    public void receive(Message msg) {
        System.out.println("Received logout from: " + msg.getSrc() + " with content: " + msg.getObject());
    }
}
