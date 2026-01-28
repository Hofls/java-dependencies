package hofls.com.github.hiber.storage.silent_rollback;

import hofls.com.github.hiber.storage.sql_file_report.VisitCount;
import hofls.com.github.hiber.storage.sql_file_report.VisitCountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import hofls.com.github.hiber.storage.junit.BaseTest;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SilentRollbackTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void problemStatement() {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            userService.problemStatement();
        });
        assertEquals("Transaction silently rolled back because it has been marked as rollback-only", exception.getMessage());
    }

}