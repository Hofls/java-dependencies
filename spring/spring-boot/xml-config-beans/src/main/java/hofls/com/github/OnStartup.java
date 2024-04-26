package hofls.com.github;

import hofls.com.github.data.DemoService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class OnStartup {

    @EventListener(ApplicationReadyEvent.class) // or @PostConstruct
    public void doSomethingAfterStartup() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        DemoService demoService = context.getBean(DemoService.class);
        demoService.printMessage();
    }

}
