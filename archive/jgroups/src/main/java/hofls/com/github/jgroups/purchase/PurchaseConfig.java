package hofls.com.github.jgroups.purchase;

import org.jgroups.JChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;

@Configuration
public class PurchaseConfig {

    @Value("${jgroup.cluster.purchase}")
    private String cluster;

    @Value("${jgroup.config}")
    private String config;

    @Autowired
    private PurchaseReceiver purchaseReceiver;

    @Bean(name = "PurchaseJChannel")
    public JChannel createPurchaseJChannel() throws Exception {
        InputStream resource = getClass().getResourceAsStream(config);
        JChannel channel = new JChannel(resource);
        channel.setReceiver(purchaseReceiver);
        channel.connect(cluster);
        return channel;
    }

}
