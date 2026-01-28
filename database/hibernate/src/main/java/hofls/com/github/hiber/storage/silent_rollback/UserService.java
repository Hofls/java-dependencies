package hofls.com.github.hiber.storage.silent_rollback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private AddressService addressService;

    @Transactional
    public String problemStatement() {
        String address = "";
        try {
            address = addressService.findAddress();
        } catch (Exception ignored) {
            // Unable to find address, but that's ok
        }

        return "John from " + address;
    }


}
