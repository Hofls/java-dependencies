package hofls.com.github.javahibernateexample.locks_demo.manual;

import hofls.com.github.javahibernateexample.hello_world.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.*;


public class BadSolutionTest extends BaseTest {

    @Autowired
    private NotificationService service;

    @Test
    public void single_lock_successful()  {
        long id = service.createNotification();
        service.badLock(id);
    }

    @Test
    public void consecutive_lock_should_throw()  {
        long id = service.createNotification();
        service.badLock(id);

        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            service.badLock(id);
        });
        assertTrue( exception.getMessage().contains("Already locked!"));
    }

    private List<Exception> exceptions = new ArrayList<>();
    private CountDownLatch validateCountdown = new CountDownLatch(2);
    /** Didn't threw, but should (look at GoodSolutionTest) */
    @Test
    public void parallel_lock_should_throw() throws InterruptedException {
        long id = service.createNotification();
        new Thread(() -> multithreadedLock(id)).start();
        new Thread(() -> multithreadedLock(id)).start();

        validateCountdown.await();
        assertEquals(0, exceptions.size());
    }

    private void multithreadedLock(long id) {
        try {
            service.badLock(id);
            validateCountdown.countDown();
        } catch (Exception e) {
            exceptions.add(e);
            validateCountdown.countDown();
            throw e;
        }
    }


}