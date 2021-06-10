package hofls.com.github.hikari.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.assertEquals;

public class CampusServiceTest extends BaseTest {

    @Autowired
    private CampusService service;

    @Autowired
    private CampusRepository repository;

    @Test
    public void connection_leak() throws Exception {
        // Transaction open for 3 seconds, while leak-detection-threshold = 2 seconds
        // Look at the logs, leak should be detected
        Thread.sleep(3000);
    }

    @Test
    public void normal_test() {
        service.save("New name");
        Campus campus = repository.findAll().get(0);
        assertEquals("New name", campus.getName());
    }

}
