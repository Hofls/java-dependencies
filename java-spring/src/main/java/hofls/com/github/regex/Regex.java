package hofls.com.github.regex;

public class Regex {

    // Java regex has problems - https://stackoverflow.com/questions/4304928/unicode-equivalents-for-w-and-b-in-java-regular-expressions
    // Should remove only special characters, but method also removes letters
    public static String removeSpecialCharacters_BAD(String text) {
        return text.replaceAll("[^\\w]+", "_");
    }
    public static String removeSpecialCharacters_GOOD(String text) {
        return text.replaceAll("(?U)[^\\w]+", "_");
    }

}
