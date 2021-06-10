package hofls.com.github.hikari.repository;

import hofls.com.github.hikari.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("junit")
@Transactional
public abstract class BaseTest {
    // without 'abstract' - junit will try to run BaseTest
}
