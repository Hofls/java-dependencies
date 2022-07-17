package hofls.com.github;

import hofls.com.github.caller.Caller;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OnStartup {

    @EventListener(ApplicationReadyEvent.class)
    public void onStartup() throws Exception {
        Caller.init();
        Caller.dial();
    }

}
