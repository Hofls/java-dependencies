package hofls.com.github.hiber.storage.silent_rollback;

import hofls.com.github.hiber.storage.locks_demo.pessimistic_lock.NotificationPess;
import hofls.com.github.hiber.storage.locks_demo.pessimistic_lock.NotificationPessRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressService {

    @Transactional
    public String findAddress() {
        if (true) throw new RuntimeException("No address was found");

        return null;
    }

}
