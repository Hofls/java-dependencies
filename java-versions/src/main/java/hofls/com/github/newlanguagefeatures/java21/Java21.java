package hofls.com.github.newlanguagefeatures.java21;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.Executors;

public class Java21 {

    // Virtual threads are way faster than OS threads
    public static void virtualThreads() {
        try(var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.submit(() -> {
                try {
                    System.out.println("Hello from virtual thread!");
                    Thread.sleep(Duration.ofSeconds(1));
                } catch (Exception ignored) {}
            });
        }
    }

    // Unnamed variables - short replacement for "ignored"
    public static void unnamedVariables() {
        var orders = List.of("a", "b", "c");
        for (var _ : orders) {
            System.out.println("Ignore order");
        }

        try {
            System.out.println("Ignore exception");
        } catch (Exception _) {}
    }

    // 3 new interfaces for Collection/Map/Set
    public void newInterfaces(SequencedCollection<String> collection, SequencedMap<String, Integer> map, SequencedSet<String> set) {
        collection.getFirst();
        map.lastEntry();
        set.reversed();
    }

    // Unnamed Classes and Instance Main Methods. Now minimal java program looks like this:
    // void main() { System.out.println("hello world"); }

}
