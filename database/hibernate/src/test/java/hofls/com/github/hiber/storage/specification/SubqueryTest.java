package hofls.com.github.hiber.storage.specification;

import hofls.com.github.hiber.storage.junit.BaseTest;
import hofls.com.github.hiber.storage.junit.BaseWithTransaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubqueryTest extends BaseWithTransaction {

    @Resource
    private EmployeeRepository employeeRepository;

    @Resource
    private ShopRepository shopRepository;

    @Autowired
    private EntityManager entityManager;

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
