package hofls.com.github.hiber.storage.silent_rollback;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import hofls.com.github.hiber.storage.junit.BaseTest;
import org.springframework.transaction.UnexpectedRollbackException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SilentRollbackTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void problemStatement() {
        UnexpectedRollbackException exception = Assertions.assertThrows(UnexpectedRollbackException.class, () -> {
            userService.problemStatement();
        });
        assertEquals("Transaction silently rolled back because it has been marked as rollback-only", exception.getMessage());
    }

    @Test
    public void solutionNoRollback() {
        assertEquals("John", userService.solutionNoRollback());
    }

    @Test
    public void solutionRequiresNew() {
        assertEquals("John", userService.solutionRequiresNew());
    }

    @Test
    public void solutionCustomAnnotation() {
        assertEquals("John", userService.solutionCustomAnnotation());
    }

}