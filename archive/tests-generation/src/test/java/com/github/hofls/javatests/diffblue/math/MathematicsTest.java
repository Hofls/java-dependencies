package com.github.hofls.javatests.diffblue.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MathematicsTest {
    @Test
    public void testSum() {
        assertEquals(2, Mathematics.sum(1, 1));
        assertEquals(-3333, Mathematics.sum(-3333, 1));
    }
}

