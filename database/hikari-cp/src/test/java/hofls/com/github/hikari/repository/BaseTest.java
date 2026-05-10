package hofls.com.github.hikari.repository;

import hofls.com.github.hikari.Application;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = Application.class)
@ActiveProfiles("junit")
@Transactional
public abstract class BaseTest {
    // without 'abstract' - junit will try to run BaseTest
}
