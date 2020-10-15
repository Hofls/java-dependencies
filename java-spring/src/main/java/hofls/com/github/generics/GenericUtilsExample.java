package hofls.com.github.generics;

import org.apache.commons.lang3.StringUtils;
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

    public static <T extends Number> String toString(T value) {
        return value != null ? value.toString() : StringUtils.EMPTY;
    }

}
