package hofls.com.github.threads.async;

import hofls.com.github.threads.FutureDemo;
import org.junit.jupiter.api.Test;

class FutureDemoTest {

    @Test
    void testRunInParallel() {
        new FutureDemo().runInParallel();
    }
}
