package com.github.hofls;

import com.github.hofls.redis.logout.LogoutPublisher;
import com.github.hofls.redis.purchase.Purchase;
import com.github.hofls.redis.purchase.PurchasePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OnStartup {

    @Autowired
    private LogoutPublisher logoutPublisher;
    @Autowired
    private PurchasePublisher purchasePublisher;

    @EventListener(ApplicationReadyEvent.class)
    public void onStartup() throws Exception {
        logoutPublisher.publishMessage();
        purchasePublisher.publishMessage(new Purchase(874, 20));
        Thread.sleep(1500L);
        System.exit(0);
    }

}
