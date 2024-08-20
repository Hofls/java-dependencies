package hofls.com.github.threads.async;

import hofls.com.github.threads.AsyncService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.concurrent.ConcurrentLinkedQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AsyncServiceTest {

    @Autowired
    AsyncService asyncService;

    @Test
    public void printAsync() throws Exception {
        var queue = new ConcurrentLinkedQueue<String>();
        asyncService.printAsync("world!", 90, queue);
        asyncService.printAsync("Hello", 10, queue);
        Thread.sleep(200);

        assertEquals("[Hello, world!]", queue.toString());
    }

    @Test
    public void printThread() throws Exception {
        var queue = new ConcurrentLinkedQueue<String>();
        asyncService.printThread("world!", 90, queue);
        asyncService.printThread("Hello", 10, queue);
        Thread.sleep(200);

        assertEquals("[Hello, world!]", queue.toString());
    }

    @Test
    public void printExecutor() throws Exception {
        var queue = new ConcurrentLinkedQueue<String>();
        asyncService.printExecutor("world!", 90, queue);
        asyncService.printExecutor("Hello", 10, queue);
        Thread.sleep(200);

        assertEquals("[Hello, world!]", queue.toString());
    }

    @Test
    public void printScheduledExecutor() throws Exception {
        var queue = new ConcurrentLinkedQueue<String>();
        asyncService.printScheduledExecutor("world!", 90, queue);
        asyncService.printScheduledExecutor("Hello", 10, queue);
        Thread.sleep(200);

        assertEquals("[Hello, world!]", queue.toString());
    }

    @Test
    public void printForkJoin() throws Exception {
        var queue = new ConcurrentLinkedQueue<String>();
        asyncService.printForkJoin("world!", 90, queue);
        asyncService.printForkJoin("Hello", 10, queue);
        Thread.sleep(200);

        assertEquals("[Hello, world!]", queue.toString());
    }

}
