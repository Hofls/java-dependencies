package hofls.com.github.postgres;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.LogManager;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("junit")
@Transactional
public abstract class BaseTest {

    @Autowired private DataSource dataSource;

    private static PostgreSQLContainer postgresContainer;

    @DynamicPropertySource
    static void dynamicJdbcUrl(DynamicPropertyRegistry registry) {
        // Postgres JDBC driver uses JUL; disable it to avoid annoying, irrelevant, stderr logs during connection testing:
        LogManager.getLogManager().getLogger("").setLevel(Level.OFF);
        // Container:
        postgresContainer = new PostgreSQLContainer<>("postgres:9.6.12");
        postgresContainer.start();

        registry.add("spring.datasource.url", postgresContainer::getJdbcUrl);
    }

    ResultSet performQuery(String sql) throws SQLException {
        Statement statement = dataSource.getConnection().createStatement();
        statement.execute(sql);
        ResultSet resultSet = statement.getResultSet();

        resultSet.next();
        return resultSet;
    }

}

