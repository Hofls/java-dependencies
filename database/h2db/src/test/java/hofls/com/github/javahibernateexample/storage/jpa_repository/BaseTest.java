package hofls.com.github.javahibernateexample.storage.jpa_repository;

import hofls.com.github.javahibernateexample.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("junit")
public abstract class BaseTest {
    // without 'abstract' - junit will try to run BaseTest
}
