package hofls.com.github.newlanguagefeatures.java9.interfaces;

/** Interface private methods */
public interface Logger {

    default void log(String message) {
        toConsole(message);
    }

    private void toConsole(String message) {
        System.out.println(message);
    }

}
