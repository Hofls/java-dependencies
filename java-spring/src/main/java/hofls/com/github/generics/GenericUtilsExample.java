package hofls.com.github.generics;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GenericUtilsExample {

    public static <T> List<T> removeNulls(List<T> elements) {
        if (CollectionUtils.isEmpty(elements)) {
            return new ArrayList<>();
        }

        return elements.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public static <N extends Number> String toString(N value) {
        return value != null ? value.toString() : "";
    }

}
