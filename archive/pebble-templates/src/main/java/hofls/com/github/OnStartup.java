package hofls.com.github;


import io.pebbletemplates.pebble.PebbleEngine;
import io.pebbletemplates.pebble.template.PebbleTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@Component
public class OnStartup {

    @EventListener(ApplicationReadyEvent.class)
    public void onStartup() throws Exception {
        PebbleEngine engine = new PebbleEngine.Builder().build();
        PebbleTemplate compiledTemplate = engine.getTemplate("home.html");

        Map<String, Object> context = new HashMap<>();
        context.put("name", "Mitchell");

        Writer writer = new StringWriter();
        compiledTemplate.evaluate(writer, context);

        String output = writer.toString();
        System.out.println(output);
    }

}
