package hofls.com.github.h2db.hello_world;

import hofls.com.github.h2db.Application;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("junit")
// @Transactional
public abstract class BaseTest {
    // without 'abstract' - junit will try to run BaseTest
}
