package hofls.com.github.hiber.storage.locks_demo.optimistic_lock;



import hofls.com.github.hiber.storage.junit.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.*;

public class NotificationOptTest extends BaseTest {

    @Autowired
    private NotificationOptService service;

    @Test
    public void single_lock_successful()  {
        long id = service.createNotification();
        service.optimisticLock(id);
    }

    @Test
    public void consecutive_lock_should_throw()  {
        long id = service.createNotification();
        service.optimisticLock(id);

        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            service.optimisticLock(id);
        });
        assertTrue(exception.getMessage().contains("Already locked!"));
    }

    private List<Exception> exceptions = new ArrayList<>();
    private CountDownLatch validateCountdown = new CountDownLatch(2);
    @Test
    public void parallel_lock_should_throw() throws InterruptedException {
        long id = service.createNotification();
        new Thread(() -> multithreadedLock(id)).start();
        new Thread(() -> multithreadedLock(id)).start();

        String expected = "optimistic locking failed; " +
                "nested exception is org.hibernate.StaleObjectStateException: " +
                "Row was updated or deleted by another transaction";
        validateCountdown.await();
        assertEquals(1, exceptions.size());
        assertTrue(exceptions.get(0).getMessage().contains(expected));
    }

    private void multithreadedLock(long id) {
        try {
            service.optimisticLock(id);
            validateCountdown.countDown();
        } catch (Exception e) {
            exceptions.add(e);
            validateCountdown.countDown();
            throw e;
        }
    }


}