package hofls.com.github.javahibernateexample.storage.specification;

import hofls.com.github.javahibernateexample.storage.JpaConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JpaConfig.class })
@Transactional
public class SubqueryTest {

    @Resource
    private EmployeeRepository employeeRepository;

    @Resource
    private ShopRepository shopRepository;

    @Test
    public void multiple_predicates() {
        Shop bananaShop = new Shop();
        bananaShop.setName("Banana shop");
        shopRepository.save(bananaShop);

        Employee employee = new Employee();
        employee.setName("David");
        employee.setShop(bananaShop);
        employeeRepository.save(employee);

        List<Employee> employees = employeeRepository.findAll(new SubquerySpecification("Banana shop"));

        assertEquals(1, employees.size());
        assertEquals("David", employees.get(0).getName());
        assertEquals("Banana shop", employees.get(0).getShop().getName());
    }

}
