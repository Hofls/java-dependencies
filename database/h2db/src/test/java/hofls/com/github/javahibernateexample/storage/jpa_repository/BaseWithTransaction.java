package hofls.com.github.javahibernateexample.storage.jpa_repository;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BaseWithTransaction extends BaseTest {
    // without 'abstract' - junit will try to run BaseWithTransaction
}
