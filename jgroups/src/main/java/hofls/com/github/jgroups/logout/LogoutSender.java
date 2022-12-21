package hofls.com.github.jgroups.logout;

import hofls.com.github.jgroups.purchase.Purchase;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class LogoutSender {

    @Autowired
    @Qualifier("LogoutJChannel")
    private JChannel channel;

    public void sendMessage() throws Exception {
        System.out.println("Send logout event");
        channel.send(new Message(null, "{userId: 7261}"));
    }

}
