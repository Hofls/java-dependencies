package hofls.com.github;

import feign.FeignException;
import hofls.com.github.exception.CustomException;
import hofls.com.github.feign.FeignMirror;
import hofls.com.github.feign.FileFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class OnStartup {

    @Autowired
    private FeignMirror feignMirror;

    @Autowired
    private FileFeign fileFeign;

    @EventListener(ApplicationReadyEvent.class)
    public void onStartup() throws Exception {
        boolean runMirror = false;
        boolean runErrors = true;
        boolean runFile = false;

        if (runMirror) {
            String reflected = feignMirror.reflect("hello!");
            System.out.println(reflected);
        }

        if (runErrors) {
            try {
                feignMirror.throwCustomError();
            } catch (CustomException e) {
                System.out.println(e.getData().errorCode);
            }

            try {
                feignMirror.throwError();
            } catch (FeignException e) {
                System.out.println(e.getMessage());
            }
        }

        if (runFile) {
            ResponseEntity<byte[]> file = fileFeign.getFile();
            System.out.println("Got file!");
        }

    }

}
