package hofls.com.github.newlanguagefeatures.java12.strings;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

// String methods: indent, transform
public class Strings {

    public static String indent() {
        return "Hey\nHo".indent(3);
    }

    public static String transform() {
        Integer number =  "42".transform(Integer::parseInt);
        String helloWorld =  "  hello"
                .transform(s -> s + " world  ")
                .transform(String::toUpperCase)
                .transform(String::strip);
        return helloWorld;
    }

}
