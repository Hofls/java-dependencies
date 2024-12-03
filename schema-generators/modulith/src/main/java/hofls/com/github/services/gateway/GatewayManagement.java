package hofls.com.github.services.gateway;

import hofls.com.github.services.department.DepartmentManagement;
import hofls.com.github.services.employee.EmployeeManagement;
import hofls.com.github.services.organization.OrganizationManagement;
import org.springframework.web.bind.annotation.*;
import hofls.com.github.services.department.DepartmentDTO;
import hofls.com.github.services.employee.EmployeeDTO;
import hofls.com.github.services.organization.OrganizationDTO;

@RestController
@RequestMapping("/api")
public class GatewayManagement {

    public DepartmentManagement departmentExternalAPI;
    public EmployeeManagement employeeExternalAPI;
    public OrganizationManagement organizationExternalAPI;

    public GatewayManagement(DepartmentManagement departmentExternalAPI,
                             EmployeeManagement employeeExternalAPI,
                             OrganizationManagement organizationExternalAPI) {
        this.departmentExternalAPI = departmentExternalAPI;
        this.employeeExternalAPI = employeeExternalAPI;
        this.organizationExternalAPI = organizationExternalAPI;
    }

    @PostMapping("/organizations")
    public OrganizationDTO apiAddOrganization(@RequestBody OrganizationDTO o) {
        return organizationExternalAPI.add(o);
    }

    @PostMapping("/employees")
    public EmployeeDTO apiAddEmployee(@RequestBody EmployeeDTO employee) {
        return employeeExternalAPI.add(employee);
    }

    @PostMapping("/departments")
    public DepartmentDTO apiAddDepartment(@RequestBody DepartmentDTO department) {
        return departmentExternalAPI.add(department);
    }
}
