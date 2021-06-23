package hofls.com.github.hiber.storage.locks_demo.manual;


import hofls.com.github.hiber.storage.junit.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.*;


public class GoodSolutionTest extends BaseTest {

    @Autowired
    private NotificationService service;

    @Test
    public void single_lock_successful()  {
        long id = service.createNotification();
        service.goodLock(id);
    }

    @Test
    public void consecutive_lock_should_throw()  {
        long id = service.createNotification();
        service.goodLock(id);

        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            service.goodLock(id);
        });
        assertTrue(exception.getMessage().contains("could not execute statement"));
    }

    private List<Exception> exceptions = new ArrayList<>();
    private CountDownLatch validateCountdown = new CountDownLatch(2);
    @Test
    public void parallel_lock_should_throw() throws InterruptedException {
        long id = service.createNotification();
        new Thread(() -> multithreadedLock(id)).start();
        new Thread(() -> multithreadedLock(id)).start();

        validateCountdown.await();
        assertEquals(1, exceptions.size());
        assertTrue(exceptions.get(0).getMessage().contains("could not execute statement"));
    }


    private void multithreadedLock(long id) {
        try {
            service.goodLock(id);
            validateCountdown.countDown();
        } catch (Exception e) {
            exceptions.add(e);
            validateCountdown.countDown();
            throw e;
        }
    }

}
