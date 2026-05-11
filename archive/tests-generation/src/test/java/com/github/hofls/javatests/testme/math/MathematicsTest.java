package com.github.hofls.javatests.testme.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MathematicsTest {

    @Test
    void testSum() {
        int result = Mathematics.sum(0, 0);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testDivideByNull() {
        Mathematics.divideByNull();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme