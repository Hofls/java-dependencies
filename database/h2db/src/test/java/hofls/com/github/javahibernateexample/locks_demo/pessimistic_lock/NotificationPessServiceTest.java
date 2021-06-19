package hofls.com.github.javahibernateexample.locks_demo.pessimistic_lock;

import hofls.com.github.javahibernateexample.hello_world.BaseTest;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class NotificationPessServiceTest extends BaseTest {

    @Autowired
    private NotificationPessService service;

    @Test
    public void single_lock_successful()  {
        long id = service.createNotification();
        service.pessimisticLock(id);
    }

    @Test
    public void consecutive_lock_should_throw()  {
        long id = service.createNotification();
        service.pessimisticLock(id);

        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            service.pessimisticLock(id);
        });
        assertTrue(exception.getMessage().contains("Already locked!"));
    }

    /** Look at exception in logs */
    @Test
    public void parallel_lock_should_throw() throws InterruptedException {
        long id = service.createNotification();
        new Thread(() -> service.pessimisticLock(id)).start();
        new Thread(() -> service.pessimisticLock(id)).start();

        Thread.sleep(500); // wait for threads
    }
}