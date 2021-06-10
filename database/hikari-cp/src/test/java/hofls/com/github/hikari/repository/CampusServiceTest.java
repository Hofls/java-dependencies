package hofls.com.github.hikari.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import static org.junit.Assert.assertEquals;

public class CampusServiceTest extends BaseTest {

    @Autowired
    private CampusService service;

    @Autowired
    private CampusRepository repository;

    @Test
    public void findById_test2() {
        service.save("New name");
        Campus campus = repository.findAll().get(0);
        assertEquals("New name", campus.getName());
    }

}
