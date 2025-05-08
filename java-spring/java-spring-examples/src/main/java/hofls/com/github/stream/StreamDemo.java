package hofls.com.github.stream;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public static Map<Long, Address> toMap(List<Address> list) {
        return list.stream()
                .collect(Collectors.toMap(Address::getId, Function.identity()));
    }

    public static Set<String> extractCities(List<Company> companies) {
        return companies.stream()
                .flatMap(company -> company.addresses.stream()) // Combines all address streams into one
                .map(address -> address.city)
                .collect(Collectors.toSet());
    }

    static class Company {
        public List<Address> addresses;
    }

    static class Address {
        public Long id;
        public String city;
        public String street;
        public String house;

        public Long getId() {
            return id;
        }
    }

}
