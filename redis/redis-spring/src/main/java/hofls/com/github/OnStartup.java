package hofls.com.github;

import hofls.com.github.redis.keyvalue.KeyValueService;
import hofls.com.github.redis.logout.LogoutPublisher;
import hofls.com.github.redis.purchase.Purchase;
import hofls.com.github.redis.purchase.PurchasePublisher;
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

    @EventListener(ApplicationReadyEvent.class)
    public void onStartup() throws Exception {
        keyValueService.set("msg", "Hello!");
        keyValueService.get("msg");
        logoutPublisher.publishMessage();
        purchasePublisher.publishMessage(new Purchase(874, 20));
        Thread.sleep(1500L);
        System.exit(0);
    }

}
