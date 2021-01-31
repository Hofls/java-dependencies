package com.github.hofls.javatests.unit;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class UnitTestMultithreaded {

    private int iterations = 100;
    private CountDownLatch validateCountdown = new CountDownLatch(iterations);

    @Test
    public void should_return_max_value() throws InterruptedException {
        for (int i = 0 ; i < iterations; i++) {
            new Thread(this::assertMaxValue).start();
        }
        validateCountdown.await();
    }

    private void assertMaxValue() {
        try {
            assertEquals(5, Math.max(2, 5));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
        validateCountdown.countDown();
    }


}
