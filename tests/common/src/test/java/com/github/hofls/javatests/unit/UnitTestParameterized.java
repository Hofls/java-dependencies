package com.github.hofls.javatests.unit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class UnitTestParameterized {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE})
    void should_return_true_for_odd_nubmers(int number) {
        assertTrue(Mathematics.isOdd(number));
    }

}
