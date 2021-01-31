package hofls.com.github.javahibernateexample.storage.report;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class VisitCountTest {

    @Autowired
    private VisitCountRepository visitCountRepository;

    @Test
    @Sql("should_build_report.sql")
    public void should_build_report() throws IOException {
        LocalDate minBirthDate = LocalDate.of(1990, 1, 23);
        Long excludeBranchId = 932L;

        List<VisitCount> visitCounts = visitCountRepository.read(excludeBranchId, minBirthDate);
        Assert.assertEquals(Long.valueOf(43040L), visitCounts.get(0).getId());
        Assert.assertEquals(Long.valueOf(99), visitCounts.get(0).getAge());
        Assert.assertEquals(Long.valueOf(43050L), visitCounts.get(1).getId());
        Assert.assertEquals(Long.valueOf(100), visitCounts.get(1).getAge());
        Assert.assertEquals(2, visitCounts.size());
    }

}