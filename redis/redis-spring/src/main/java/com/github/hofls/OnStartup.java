package com.github.hofls;

import com.github.hofls.redis.cache.CachedService;
import com.github.hofls.redis.keyvalue.KeyValueService;
import com.github.hofls.redis.pubsub.logout.LogoutPublisher;
import com.github.hofls.redis.pubsub.purchase.Purchase;
import com.github.hofls.redis.pubsub.purchase.PurchasePublisher;
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
    @Autowired
    private KeyValueService keyValueService;
    @Autowired
    private CachedService cachedService;

    @EventListener(ApplicationReadyEvent.class)
    public void onStartup() throws Exception {
        keyValueService.set("msg", "Hello!");
        keyValueService.get("msg");

        logoutPublisher.publishMessage();
        purchasePublisher.publishMessage(new Purchase(874, 20));

        cachedService.getProductById("7634");
        cachedService.getProductById("7634");

        Thread.sleep(1500L);
        System.exit(0);
    }

}
