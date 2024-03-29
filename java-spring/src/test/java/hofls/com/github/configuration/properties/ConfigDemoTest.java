package hofls.com.github.configuration.properties;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ConfigDemoTest {

    @Autowired
    private ConfigDemo configDemo;

    @Test
    void getHello_test() {
        assertEquals("Hola!", configDemo.getHello());
    }

}