package hofls.com.github.newlanguagefeatures.java9.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Stream API, new methods
public class NumbersCrunch {

    public static List<Integer> iterate() {
        return Stream.iterate(0, i -> i < 3, i -> i + 1)
                .collect(Collectors.toList());
    }

    public static List<Integer> takeWhile() {
        List<Integer> elements = Arrays.asList(1, 2, 5, 4, 3);
        return elements.stream()
                .takeWhile(i -> (i < 5))
                .collect(Collectors.toList());
    }

    public static List<Integer> dropWhile() {
        List<Integer> elements = Arrays.asList(1, 2, 5, 4, 3);
        return elements.stream()
                .dropWhile(i -> (i < 5))
                .collect(Collectors.toList());
    }

}
