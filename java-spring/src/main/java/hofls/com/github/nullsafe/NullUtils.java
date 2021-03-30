package hofls.com.github.nullsafe;

import java.util.function.Supplier;

public class NullUtils {

    public static <T> T safe(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            return null;
        }
    }

    static <T> T safe(Supplier<T> supplier, T defaultValue) {
        try {
            return supplier.get();
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            return defaultValue;
        }
    }

}
