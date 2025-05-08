package hofls.com.github;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
public class OnStartup {

    @Autowired
    private RabbitSender rabbitSender;

    @EventListener(ApplicationReadyEvent.class) // or @PostConstruct
    public void doSomethingAfterStartup()  {
        rabbitSender.send("Hello world");
    }

}
