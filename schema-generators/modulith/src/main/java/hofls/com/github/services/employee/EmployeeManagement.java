package hofls.com.github.services.employee;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeManagement {

    @Transactional
    public EmployeeDTO add(EmployeeDTO employee) {
        return employee;
    }

}
