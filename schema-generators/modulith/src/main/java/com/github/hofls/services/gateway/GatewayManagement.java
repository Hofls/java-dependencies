package com.github.hofls.services.gateway;

import com.github.hofls.services.department.DepartmentManagement;
import com.github.hofls.services.employee.EmployeeManagement;
import com.github.hofls.services.organization.OrganizationManagement;
import org.springframework.web.bind.annotation.*;
import com.github.hofls.services.department.DepartmentDTO;
import com.github.hofls.services.employee.EmployeeDTO;
import com.github.hofls.services.organization.OrganizationDTO;

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
