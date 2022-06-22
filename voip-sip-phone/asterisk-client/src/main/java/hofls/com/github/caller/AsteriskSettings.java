package hofls.com.github.caller;

import org.asteriskjava.pbx.DefaultAsteriskSettings;
import org.springframework.stereotype.Component;

@Component
public class AsteriskSettings extends DefaultAsteriskSettings {

    @Override
    public String getManagerPassword() {
        // this password MUST match the password (secret=) in manager.conf
        return "qwerty";
    }

    @Override
    public String getManagerUsername() {
        // this MUST match the section header '[myconnection]' in manager.conf
        return "hofls";
    }

    @Override
    public String getAsteriskIP() {
        // The IP address or FQDN of your Asterisk server.
        return "2.2.2.2.";
    }

    /**
     * 5038 = Asterisk Manager API (TCP)
     * 5060 = SIP (UDP)
     */
    @Override
    public int getManagerPortNo() {
        return 5038;
    }

    @Override
    public String getAgiHost() {
        // The IP Address or FQDN of you asterisk-java application.
        return "1.1.1.1";
    }

}
