package hofls.com.github;

import java.util.Arrays;

public class TextGenerator {

    // delete this method, if you want 'spotbugs' to pass
    public void test() {
        String result = "";
        for (String field : Arrays.asList("a", "b")) {
            result += field;
        }
    }

    public static String generate(int i) {
        if (i > 0) {
            return "abc";
        } else {
            return "def";
        }
    }
}
