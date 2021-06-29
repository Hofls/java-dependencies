package hofls.com.github.hiber.storage.junit;

import hofls.com.github.hiber.Application;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("junit")
public abstract class BaseTest {
    // without 'abstract' - junit will try to run BaseTest

    // to clear without @Transactional:
    // @BeforeEach
    // public void clearTables() {
    //     repository.deleteAll();
    // }
}
