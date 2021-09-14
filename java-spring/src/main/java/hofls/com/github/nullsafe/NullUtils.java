package hofls.com.github.nullsafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class NullUtils {

    public static <T> T safe(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            return null;
        }
    }

    public static <T> T safe(Supplier<T> supplier, T defaultValue) {
        try {
            return supplier.get();
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            return defaultValue;
        }
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

}
