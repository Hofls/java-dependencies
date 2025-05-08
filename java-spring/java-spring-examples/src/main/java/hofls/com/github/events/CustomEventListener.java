package hofls.com.github.events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CustomEventListener implements ApplicationListener<CustomEvent> {

    public String lastMessage = "";

    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("Received message: " + event.getMessage());
        lastMessage = event.getMessage();
    }
}

