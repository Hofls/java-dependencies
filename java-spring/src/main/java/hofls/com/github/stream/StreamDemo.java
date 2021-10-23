package hofls.com.github.stream;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class StreamDemo {

    public static List<Integer> multiplyByTwo(List<Integer> elements) {
        return elements.stream()
                .map(i -> i * 2)
                .collect(Collectors.toList());
    }

    public static  LocalDate minDate(List<LocalDate> dates) {
        return dates.stream()
                .filter(Objects::nonNull)
                .min(LocalDate::compareTo)
                .orElse(null);
    }

    public static  List<Integer> sideEffects(List<Integer> elements) {
        List<Integer> sideEffects = new ArrayList<>();
        elements.stream()
                .filter(Objects::nonNull)
                .distinct()
                .forEach(sideEffects::add);
        return sideEffects;
    }

    public static  String toString(List<String> elements) {
        return elements.stream().collect(Collectors.joining(", ", "{", "}"));
    }

    public static  Map<String, List<Address>> groupByCity(List<Address> elements) {
        return elements.stream()
                .collect(Collectors.groupingBy(address -> address.city));
    }

    public static Map<String, Long> countByCity(List<Address> elements) {
        return elements.stream()
                .collect(Collectors.groupingBy(address -> address.city, Collectors.counting()));
    }

    static class Address {
        public String city;
        public String street;
        public String house;
    }

}
