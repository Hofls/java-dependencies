package com.github.hofls.javatests.unit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UnitTest {

    @Test
    public void should_return_max_value() {
        assertEquals(7, Mathematics.sum(2, 5));
    }

}
