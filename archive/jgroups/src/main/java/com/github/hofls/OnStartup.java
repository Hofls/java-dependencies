package com.github.hofls;

import com.github.hofls.jgroups.logout.LogoutReceiver;
import com.github.hofls.jgroups.logout.LogoutSender;
import com.github.hofls.jgroups.purchase.Purchase;
import com.github.hofls.jgroups.purchase.PurchaseSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class OnStartup {

    @Autowired
    private PurchaseSender purchaseSender;

    @Autowired
    private LogoutSender logoutSender;

    @EventListener(ApplicationReadyEvent.class)
    public void onStartup() throws Exception {
        Purchase purchase = new Purchase(874, OffsetDateTime.now());
        purchaseSender.sendMessage(purchase);
        logoutSender.sendMessage();
        Thread.sleep(1500L);
        System.exit(0);
    }

}
