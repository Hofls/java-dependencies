package hofls.com.github.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RetryUtilsTest {

    @Test
    void retry_success() throws Exception {
        RetryUtils.retry(
                () -> {
                    int i = 23;
                });
    }

    @Test
    void retry_failure() {
        Exception expectedException =
                Assertions.assertThrows(
                        RuntimeException.class,
                        () -> {
                            RetryUtils.retry(
                                    () -> {
                                        throw new RuntimeException("total failure");
                                    },
                                    1);
                        });
        assertEquals("total failure", expectedException.getMessage());
    }
}
