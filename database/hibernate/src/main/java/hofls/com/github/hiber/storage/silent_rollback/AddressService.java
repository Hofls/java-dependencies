package hofls.com.github.hiber.storage.silent_rollback;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressService {

    @Transactional
    public String problemStatement() {
        throw new RuntimeException("Address service is unavailable");
    }

    @Transactional(noRollbackFor = RuntimeException.class)
    public String solutionNoRollback() {
        throw new RuntimeException("Address service is unavailable");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String solutionRequiresNew() {
        throw new RuntimeException("Address service is unavailable");
    }

    @TransactionalNoRollback
    public String solutionCustomAnnotation() {
        throw new RuntimeException("Address service is unavailable");
    }

}
