package hofls.com.github.threads;

import java.util.concurrent.CompletableFuture;

public class FutureDemo {

    // e.g. - send multiple requests in parallel, wait for all responses
    public void runInParallel() {
        CompletableFuture<Void> futureA = CompletableFuture.runAsync(()->{
            try {
                Thread.sleep(100);
                System.out.println("second");
            } catch (Exception ignored) {}
        });

        CompletableFuture<Void> futureB = CompletableFuture.runAsync(()->{
            try {
                Thread.sleep(30);
                System.out.println("first");
            } catch (Exception ignored) {}
        });

        CompletableFuture<Void> futures = CompletableFuture.allOf(futureA, futureB);
        try {
            futures.get();
        } catch (Exception ignored) {}
        System.out.println("third");
    }



}
