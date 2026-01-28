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
            address = addressService.problemStatement();
        } catch (Exception ignored) {}
        return "John" + address;
    }

    @Transactional
    public String solutionNoRollback() {
        String address = "";
        try {
            address = addressService.solutionNoRollback();
        } catch (Exception ignored) {}
        return "John" + address;
    }



}
