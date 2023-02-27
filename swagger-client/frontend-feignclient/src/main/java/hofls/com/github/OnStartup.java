package hofls.com.github;

import feign.FeignException;
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

        try {
            feignMirror.throwError();
        } catch (FeignException e) {
            System.out.println(e.contentUTF8()); // next convert to object, e.g. via jsonToObject()
        }
    }

}
