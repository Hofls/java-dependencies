package com.github.hofls.javatests.squaretest.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MathematicsTest {

    @Test
    void testSum() {
        assertEquals(0, Mathematics.sum(0, 0));
    }

    @Test
    void testDivideByNull() {
        // Setup

        // Run the test
        Mathematics.divideByNull();

        // Verify the results
    }
}
