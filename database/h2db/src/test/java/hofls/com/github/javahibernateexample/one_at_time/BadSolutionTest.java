package hofls.com.github.javahibernateexample.one_at_time;

import hofls.com.github.javahibernateexample.hello_world.BaseTest;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

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

    /** Didn't threw, but should (look at GoodSolutionTest) */
    @Test
    public void parallel_lock_should_throw() throws InterruptedException {
        long id = service.createNotification();
        new Thread(() -> service.badLock(id)).start();
        new Thread(() -> service.badLock(id)).start();

        Thread.sleep(500); // wait for threads
    }

}