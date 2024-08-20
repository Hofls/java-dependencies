package hofls.com.github.threads;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Service
public class AsyncService {

    @Autowired
    private ExecutorService executorService;

    @Autowired
    private ScheduledExecutorService scheduledExecutor;


    @Async // Won't work without @EnableAsync
    @SneakyThrows
    public void printAsync(String message, int waitMs, ConcurrentLinkedQueue<String> queue) {
        Thread.sleep(waitMs);
        queue.add(message);
    }

    // Just works, no need for anything extra
    public void printThread(String message, int waitMs, ConcurrentLinkedQueue<String> queue) {
        new Thread(() -> {
            try {
                Thread.sleep(waitMs);
            } catch (InterruptedException ignored) {}
            queue.add(message);
        }).start();
    }

    // Won't work without executorService() bean in AsyncConfig
    public void printExecutor(String message, int waitMs, ConcurrentLinkedQueue<String> queue) {
        executorService.submit(() -> {
            try {
                Thread.sleep(waitMs);
            } catch (InterruptedException ignored) {}
            queue.add(message);
        });
    }

    // Won't work without scheduledExecutor() bean in AsyncConfig
    public void printScheduledExecutor(String message, int waitMs, ConcurrentLinkedQueue<String> queue) {
        scheduledExecutor.schedule(() -> {
            queue.add(message);
        }, waitMs, TimeUnit.MILLISECONDS);
    }

    public void printForkJoin(String message, int waitMs, ConcurrentLinkedQueue<String> queue) {
        ForkJoinPool.commonPool().submit(() -> {
            try {
                Thread.sleep(waitMs);
            } catch (InterruptedException ignored) {}
            queue.add(message);
        });
    }

}
