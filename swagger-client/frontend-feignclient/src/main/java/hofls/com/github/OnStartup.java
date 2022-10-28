package hofls.com.github;

import hofls.com.github.feign.FeignMirror;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OnStartup {

    @Autowired
    private FeignMirror feignMirror;

    @EventListener(ApplicationReadyEvent.class)
    public void onStartup() throws Exception {
        String reflected = feignMirror.reflect("hello!");
        System.out.println(reflected);
    }

}
