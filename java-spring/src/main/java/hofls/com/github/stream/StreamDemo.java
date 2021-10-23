package hofls.com.github.stream;

import java.security.cert.CollectionCertStoreParameters;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamDemo {

    public List<Integer> multiplyByTwo(List<Integer> elements) {
        return elements.stream()
                .map(i -> i * 2)
                .collect(Collectors.toList());
    }

    public LocalDate minDate(List<LocalDate> dates) {
        return dates.stream()
                .filter(Objects::nonNull)
                .min(LocalDate::compareTo)
                .orElse(null);
    }

    public List<Integer> sideEffects(List<Integer> elements) {
        List<Integer> sideEffects = new ArrayList<>();
        elements.stream()
                .filter(Objects::nonNull)
                .distinct()
                .forEach(sideEffects::add);
        return sideEffects;
    }

    public Map<String, List<Address>> groupByCity(List<Address> elements) {
        return elements.stream()
                .collect(Collectors.groupingBy(address -> address.city));
    }

    static class Address {
        public String city;
        public String street;
        public String house;
    }

}
