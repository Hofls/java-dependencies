package hofls.com.github.postgres;

import hofls.com.github.postgres.campus.Campus;
import hofls.com.github.postgres.campus.CampusRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import static org.junit.Assert.assertEquals;

public class CampusRepositoryTest extends BaseTest {

    @Autowired
    private CampusRepository repository;

    @Test
    @Sql(config = @SqlConfig(encoding = "UTF-8"), scripts = "trigger_test.sql")
    public void trigger_test() {
        Campus campus = repository.findById(23L).get();
        assertEquals("Extrodee. NewYork - Advanced status", campus.getTextForSearch());
    }

}
