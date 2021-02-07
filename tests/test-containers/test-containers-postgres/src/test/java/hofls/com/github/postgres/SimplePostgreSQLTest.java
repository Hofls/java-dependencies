package hofls.com.github.postgres;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;


public class SimplePostgreSQLTest extends BaseTest {

    @Test
    public void simple_test() throws SQLException {
        ResultSet resultSet = performQuery("SELECT 1");
        int resultSetInt = resultSet.getInt(1);
        assertEquals(1, resultSetInt);
    }

    @Test
    public void uniqueFunctions_test1() throws SQLException {
        String query = "select date_part('year', (timestamp '1957-06-13'))";
        String actual = performQuery(query).getString(1);
        assertEquals("1957", actual);
    }

    @Test
    public void uniqueFunctions_test2() throws SQLException {
        String query = "select extract(month from interval '2 years 3 months')";
        String actual = performQuery(query).getString(1);
        assertEquals("3", actual);
    }

    @Test
    public void uniqueFunctions_test3() throws SQLException {
        String query = "select justify_hours(interval '27 hours')";
        String actual = performQuery(query).getString(1);
        assertEquals("1 day 03:00:00", actual);
    }
}
