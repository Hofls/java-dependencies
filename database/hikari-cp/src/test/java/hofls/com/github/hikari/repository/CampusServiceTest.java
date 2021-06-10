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
    // Try to remove "UTF-8", run `mvn test`, it will break on Windows (default encoding Windows-1252)
    @Sql(config = @SqlConfig(encoding = "UTF-8"), scripts = "findById_test.sql")
    public void findById_test() {
        Campus campus = service.findById(23L);
        assertEquals("Cyrillic campus: абвгд", campus.getName());
    }

    @Test
    public void findById_test2() {
        service.save("New name");
    }

}
