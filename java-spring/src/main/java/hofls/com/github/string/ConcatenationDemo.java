package hofls.com.github.string;


import org.springframework.util.StringUtils;

public class ConcatenationDemo {

    public static String concatenateA(String name, String city) {
        return String.format("Hello %s, are you from %s?", name, city);
    }

    public static String concatenateB(String name, String city) {
        StringBuilder builder = new StringBuilder();
        builder.append("Known info:");
        if (!StringUtils.isEmpty(name)) {
            builder.append("\nUser name - ").append(name);
        }

        if (!StringUtils.isEmpty(city)) {
            builder.append("\nVisited city - ").append(city);
        }
        return builder.toString();
    }

}
