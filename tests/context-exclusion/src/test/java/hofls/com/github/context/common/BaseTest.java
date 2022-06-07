package hofls.com.github.context.common;

import hofls.com.github.context.TestApplication;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestApplication.class)
@ActiveProfiles("junit-profile")
public abstract class BaseTest {
}
