package hofls.com.github.newlanguagefeatures.java22;

import java.math.BigInteger;
import java.util.stream.Stream;

public class Java22 {
/* Commented out, because both methods are in preview state

    // Statements before super() are now allowed
    public static class PositiveBigInteger extends BigInteger {
        public PositiveBigInteger(long value) {
            if (value <= 0) {
                throw new IllegalArgumentException("non-positive value");
            }
            super(Long.toString(value));
        }
    }

    // New stream method .gather();
    public static void streamGatherers() {
        Stream.of(1,2,3,4,5)
                .gather(Gatherers.fold(() -> "", (str, n) -> str + n))
                .findFirst()
                .get(); // "12345"

        Stream.of(1,2,3,4)
                .gather(Gatherers.scan(() -> "", (str, n) -> str + n))
                .toList(); // [1, 12, 123, 1234]

    }
*/
}
