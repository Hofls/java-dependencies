package hofls.com.github.h2db.hello_world;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BaseWithTransaction extends BaseTest {
    // without 'abstract' - junit will try to run BaseWithTransaction
}
