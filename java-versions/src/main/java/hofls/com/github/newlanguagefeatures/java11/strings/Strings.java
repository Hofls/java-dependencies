package hofls.com.github.newlanguagefeatures.java11.strings;

import java.util.List;
import java.util.stream.Collectors;

// String methods: repeat, isBlank, strip, lines
public class Strings {

    public static String repeat() {
        return "Ho ".repeat(3);
    }

    public static boolean isBlank() {
        return "    ".isBlank();
    }

    // trim() is outdated, because it does not remove all possible whitespace characters
    public static void strip() {
        "  hey  ".strip();
        "  hey  ".stripTrailing();
    }

    public static List<String> lines() {
        return "first_line\nsecond_line".lines().collect(Collectors.toList());
    }

}
