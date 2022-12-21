package hofls.com.github.jgroups.logout;

import org.jgroups.JChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;

@Configuration
public class LogoutConfig {

    @Value("${jgroup.cluster.logout}")
    private String cluster;

    @Value("${jgroup.config}")
    private String config;

    @Autowired
    private LogoutReceiver logoutReceiver;

    @Bean(name = "LogoutJChannel")
    public JChannel createLogoutJChannel() throws Exception {
        InputStream resource = getClass().getResourceAsStream(config);
        JChannel channel = new JChannel(resource);
        channel.setReceiver(logoutReceiver);
        channel.connect(cluster);
        return channel;
    }

}
