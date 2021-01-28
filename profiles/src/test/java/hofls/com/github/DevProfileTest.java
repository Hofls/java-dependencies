package hofls.com.github;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles(profiles = "dev-profile")
class DevProfileTest {

    @Value("${spring.profiles.active:}")
    private String activeProfile;

    @Test
    void should_run_as_dev() {
        assertEquals("dev-profile", activeProfile);
        // look at console output
    }

}
