package hofls.com.github.properties;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(profiles = "prod")
public class PropertiesProdTest {

    @Autowired
    PropertiesDemo propertiesDemo;

    @Test
    public void should_return_property_from_application_yml() {
        Assert.assertEquals("Hi everybody!! its a prod profile!", propertiesDemo.getGreeting());
    }


}
