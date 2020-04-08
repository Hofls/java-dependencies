package hofls.com.github.properties;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles(profiles = "prod")
public class PropertiesProdTest {

    @Autowired
    PropertiesDemo propertiesDemo;

    @Test
    public void should_return_property_from_application_yml() {
        assertEquals("Hi everybody!! its a prod profile!", propertiesDemo.getGreeting());
    }


}
