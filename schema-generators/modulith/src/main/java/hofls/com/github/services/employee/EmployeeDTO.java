package hofls.com.github.services.employee;

public record EmployeeDTO(Long id,
                          Long organizationId,
                          Long departmentId,
                          String name,
                          int age,
                          String position) {
}
