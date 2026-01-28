package hofls.com.github.hiber.storage.silent_rollback;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressService {

    @Transactional
    public String problemStatement() {
        if (true) throw new RuntimeException("Address service is unavailable");
        return null;
    }

    @Transactional(noRollbackFor = RuntimeException.class)
    public String solutionNoRollback() {
        if (true) throw new RuntimeException("Address service is unavailable");
        return null;
    }

}
