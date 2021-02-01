package hofls.com.github;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

// this test won't run automatically (e.g. on install)
@ExtendWith(SpringExtension.class)
@SpringBootTest
//@IfProfileValue(name = "spring.profiles.active", value = "manual") // for JUnit4
@EnabledIfSystemProperty(named = "spring.profiles.active", matches = "manual")
class ManualProfileTest {

    @Test
    void should_not_run() {
        assertTrue(1 == 2);
    }

}
