package hofls.com.github.newlanguagefeatures.java9.collections;

import java.util.List;
import java.util.Map;
import java.util.Set;

// Collection factory methods
public class Collections {

    void of() {
        List<String> list = List.of("foo", "bar", "baz");

        Set<String> set = Set.of("foo", "bar", "baz");

        Map<String, String> map = Map.of(
                "key1", "value1",
                "key2", "value2",
                "key3", "value3");
    }

}
