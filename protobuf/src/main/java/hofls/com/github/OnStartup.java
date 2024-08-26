package hofls.com.github;

import hofls.com.github.protobuf.HelloWorldProto;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
public class OnStartup {

    @EventListener(ApplicationReadyEvent.class) // or @PostConstruct
    public void doSomethingAfterStartup()  {
        HelloWorldProto.HelloRequest request = HelloWorldProto.HelloRequest.newBuilder()
                .setName("World")
                .build();
        HelloWorldProto.HelloResponse response = HelloWorldProto.HelloResponse.newBuilder()
                .setMessage("Hello, " + request.getName())
                .build();
        System.out.println(response.getMessage());

        System.exit(0);
    }

}
