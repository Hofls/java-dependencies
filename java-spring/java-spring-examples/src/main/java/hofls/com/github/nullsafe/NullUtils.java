package hofls.com.github.nullsafe;

import java.util.*;
import java.util.function.Supplier;

public class NullUtils {

    public static <T> T safe(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (NullPointerException | IndexOutOfBoundsException | NoSuchElementException e) {
            return null;
        }
    }

    public static <T> T safe(Supplier<T> supplier, T defaultValue) {
        try {
            return supplier.get();
        } catch (NullPointerException | IndexOutOfBoundsException | NoSuchElementException e) {
            return defaultValue;
        }
    }

    public static void safe(Runnable runnable) {
        try {
            runnable.run();
        } catch (IndexOutOfBoundsException | NullPointerException | NoSuchElementException ignored) {}
    }

    /** To avoid NullPointerException in cycles */
    public static <T> List<T> safe(List<T> list) {
        return list == null ? Collections.emptyList() : list;
    }

    public static <T> List<T> removeNulls(List<T> elements) {
        if (org.springframework.util.CollectionUtils.isEmpty(elements)) {
            return new ArrayList<>();
        }

        return elements.stream().filter(Objects::nonNull).collect(Collectors.toList());
    }

    public <T> Set<T> safe(Set<T> set) {
        return set == null ? Collections.emptySet() : set;
    }

    public <K, V> Map<K, V> safe(Map<K, V> map) {
        return map == null ? Collections.emptyMap() : map;
    }

}
