package hofls.com.github.hiber.storage.specification;


import hofls.com.github.hiber.storage.junit.BaseWithTransaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OtherTest extends BaseWithTransaction {

    @Resource
    private EmployeeRepository employeeRepository;

    @Resource
    private ShopRepository shopRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void persist_demo() {
        // How to persist (create) multiple entities with one method call
        Shop shop = new Shop();
        Employee employee = new Employee();

        shop.setEmployees(Arrays.asList(employee));
        employee.setShop(shop);
        shopRepository.saveAndFlush(shop);

        Shop actualShop = shopRepository.findById(shop.getId()).get();
        Assert.notEmpty(actualShop.getEmployees());
    }

    @Test
    @Sql("crud_demo.sql")
    public void merge_demo() {
        // How to merge (edit) multiple entities with one method call
        Shop shop = shopRepository.findById(432L).get();
        shop.setName("PC shop");
        shop.getEmployees().get(0).setName("John");

        shopRepository.save(shop);

        assertEquals("PC shop", shopRepository.findAll().get(0).getName());
        assertEquals("John", employeeRepository.findAll().get(0).getName());
    }


    @Test
    @Sql("crud_demo.sql")
    public void delete_demo() {
        // How to delete multiple entities with one method call
        assertFalse(shopRepository.findAll().isEmpty());
        assertFalse(employeeRepository.findAll().isEmpty());

        shopRepository.deleteById(432L);

        assertTrue(shopRepository.findAll().isEmpty());
        assertTrue(employeeRepository.findAll().isEmpty());
    }


    @Test
    public void first_level_hibernate_cache_demo() {
        // Fix to typical problem with @OneToMany and @ManyToOne
        Shop shop = new Shop();
        shopRepository.saveAndFlush(shop);

        Employee employee = new Employee();
        employee.setShop(shop);
        employeeRepository.saveAndFlush(employee);

        shop = shopRepository.findById(shop.getId()).get();
        entityManager.refresh(shop); // Without this line assertion will fail

        Assert.notEmpty(shop.getEmployees());
    }

}
