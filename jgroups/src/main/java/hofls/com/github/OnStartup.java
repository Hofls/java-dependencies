package hofls.com.github;

import hofls.com.github.jgroups.purchase.PurchaseSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OnStartup {

    @Autowired
    private PurchaseSender purchaseSender;

    @EventListener(ApplicationReadyEvent.class)
    public void onStartup() throws Exception {
        purchaseSender.sendMessage("Hello");
        Thread.sleep(1500L);
        System.exit(0);
    }

}
