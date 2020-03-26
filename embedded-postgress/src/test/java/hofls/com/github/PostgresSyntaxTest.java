package hofls.com.github;

import hofls.com.github.annotation.PostgresDataJpaTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@PostgresDataJpaTest
public class PostgresSyntaxTest {

    @Test
    @Sql("testUniqueSyntax.sql")
    public void testUniqueSyntax() {
        Assert.assertTrue(true);
    }

}
