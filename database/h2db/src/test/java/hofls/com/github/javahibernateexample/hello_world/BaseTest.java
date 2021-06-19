package hofls.com.github.javahibernateexample.hello_world;

import hofls.com.github.javahibernateexample.Application;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("junit")
public abstract class BaseTest {
    // without 'abstract' - junit will try to run BaseTest
}
