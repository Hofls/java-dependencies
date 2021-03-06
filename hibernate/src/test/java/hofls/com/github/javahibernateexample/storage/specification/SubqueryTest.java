package hofls.com.github.javahibernateexample.storage.specification;

import hofls.com.github.javahibernateexample.storage.junit.BaseTest;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SubqueryTest extends BaseTest {

    @Resource
    private EmployeeRepository employeeRepository;

    @Test
    @Sql("find_with_subquery.sql")
    public void find_with_subquery() {
        List<Employee> employees = employeeRepository.findAll(new SubquerySpecification("Banana shop"));
        // If you need to bring lazy collection out of the Transaction scope - Hibernate.initialize(employees.get(0));

        assertEquals(1, employees.size());
        assertEquals("David", employees.get(0).getName());
        assertEquals("Banana shop", employees.get(0).getShop().getName());
    }

}
