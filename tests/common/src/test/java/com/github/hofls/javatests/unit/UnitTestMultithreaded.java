package com.github.hofls.javatests.unit;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnitTestMultithreaded {

    private int iterations = 10;
    private CountDownLatch validateCountdown = new CountDownLatch(iterations);
    private List<Exception> exceptions = new ArrayList<>();

    @Test
    void multithread_test_demo() throws InterruptedException {
        for (int i = 0 ; i < iterations; i++) {
            new Thread(this::indexOutOfBounds).start();
        }

        validateCountdown.await(); // necessary to wait for all threads
        assertEquals(10, exceptions.size());
        assertEquals("Index: 777, Size: 0", exceptions.get(0).getMessage());
    }

    private void indexOutOfBounds() {
        try {
            exceptions.get(777);
        } catch (Exception e) {
            validateCountdown.countDown();
            exceptions.add(e);
            throw new RuntimeException(e);
        }
    }

}
