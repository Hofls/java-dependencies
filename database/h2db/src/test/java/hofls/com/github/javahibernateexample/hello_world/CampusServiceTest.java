package hofls.com.github.javahibernateexample.hello_world;

import hofls.com.github.javahibernateexample.common.TestUtils;
import lombok.val;
import lombok.var;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CampusServiceTest extends BaseWithTransaction {

    @Autowired
    private CampusService service;

    @Autowired
    private CampusRepository repository;

    @Test
    // Try to remove "UTF-8", run `mvn test`, it will break on Windows (default encoding Windows-1252)
    @Sql(config = @SqlConfig(encoding = "UTF-8"), scripts = "findById_test.sql")
    public void findById_test() {
        val campus = service.findById(23L);
        assertEquals("Cyrillic campus: абвгд", campus.getName());
    }

    @Test
    public void save_test() throws IOException {
        val campus = new Campus();
        campus.setName("English campus");
        val actual = repository.save(campus);
        var expected = TestUtils.readFile(this.getClass(), "save_test.json");
        expected = expected.replace("\"INSERT_ID_HERE\"", String.valueOf(actual.getId()));
        TestUtils.assertEqualJson(expected, actual);
    }


}
