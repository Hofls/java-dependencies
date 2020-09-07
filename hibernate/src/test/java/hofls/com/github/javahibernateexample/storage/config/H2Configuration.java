package hofls.com.github.javahibernateexample.storage.config;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class H2Configuration {

    @Bean
    public Server createH2Server()  {
        try {
            Server h2Server = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8086");
            h2Server.start();
            return h2Server;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
