package hofls.com.github.jgroups;

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

    @Bean
    public JChannel createJChannel() throws Exception {
        InputStream resource = getClass().getResourceAsStream("/config-local.xml");
        JChannel channel = new JChannel(resource);
        channel.setReceiver(purchaseReceiver);
        channel.connect("purchase_events");

        return channel;
    }

}
