package hofls.com.github;

import hofls.com.github.redis.cache.CachedService;
import hofls.com.github.redis.keyvalue.KeyValueService;
import hofls.com.github.redis.pubsub.logout.LogoutPublisher;
import hofls.com.github.redis.pubsub.purchase.Purchase;
import hofls.com.github.redis.pubsub.purchase.PurchasePublisher;
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
