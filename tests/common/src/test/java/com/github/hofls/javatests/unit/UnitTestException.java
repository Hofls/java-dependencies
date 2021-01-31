package com.github.hofls.javatests.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTestException {

    @Test
    public void should_find_possessed_field() throws IllegalAccessException {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            Mathematics.divideByNull();
        });
        assertEquals("Quit trying to destroy the universe please", exception.getMessage());
    }


}
