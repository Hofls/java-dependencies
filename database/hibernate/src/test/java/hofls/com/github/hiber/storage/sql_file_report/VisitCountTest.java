package hofls.com.github.hiber.storage.sql_file_report;

import hofls.com.github.hiber.storage.junit.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class VisitCountTest extends BaseTest {

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

    public static int age(Date dateEnd, Date dateStart) {
        Period period = Period.between(dateStart.toLocalDate(), dateEnd.toLocalDate());
        return period.getYears();
    }

    public static int datePart(String period, int age) {
        return age;
    }

}