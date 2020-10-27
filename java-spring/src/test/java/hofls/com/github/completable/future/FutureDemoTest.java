package hofls.com.github.completable.future;

import hofls.com.github.completabale.future.FutureDemo;
import org.junit.jupiter.api.Test;

class FutureDemoTest {

    @Test
    void testRunInParallel() {
        new FutureDemo().runInParallel();
    }
}
