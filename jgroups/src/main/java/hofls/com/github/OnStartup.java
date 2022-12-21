package hofls.com.github;

import hofls.com.github.jgroups.logout.LogoutReceiver;
import hofls.com.github.jgroups.logout.LogoutSender;
import hofls.com.github.jgroups.purchase.Purchase;
import hofls.com.github.jgroups.purchase.PurchaseSender;
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
