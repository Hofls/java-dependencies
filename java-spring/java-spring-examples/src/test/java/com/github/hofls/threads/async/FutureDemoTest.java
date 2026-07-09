package com.github.hofls.threads.async;

import com.github.hofls.threads.FutureDemo;
import org.junit.jupiter.api.Test;

class FutureDemoTest {

    @Test
    void testRunInParallel() {
        new FutureDemo().runInParallel();
    }
}
