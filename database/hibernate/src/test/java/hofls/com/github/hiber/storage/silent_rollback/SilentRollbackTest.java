package hofls.com.github.hiber.storage.silent_rollback;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import hofls.com.github.hiber.storage.junit.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void solutionNoRollback() {
        assertEquals("John", userService.solutionNoRollback());
    }

}