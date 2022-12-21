package hofls.com.github.jgroups;

import hofls.com.github.jgroups.logout.LogoutReceiver;
import hofls.com.github.jgroups.purchase.PurchaseReceiver;
import org.jgroups.JChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;

@Configuration
public class JGroupsConfig {

    @Autowired
    private PurchaseReceiver purchaseReceiver;

    @Autowired
    private LogoutReceiver logoutReceiver;

    @Bean(name = "PurchaseJChannel")
    public JChannel createPurchaseJChannel() throws Exception {
        InputStream resource = getClass().getResourceAsStream("/config-local.xml");
        JChannel channel = new JChannel(resource);
        channel.setReceiver(purchaseReceiver);
        channel.connect("purchase_events");
        return channel;
    }

    @Bean(name = "LogoutJChannel")
    public JChannel createLogoutJChannel() throws Exception {
        InputStream resource = getClass().getResourceAsStream("/config-local.xml");
        JChannel channel = new JChannel(resource);
        channel.setReceiver(logoutReceiver);
        channel.connect("logout_events");
        return channel;
    }

}
