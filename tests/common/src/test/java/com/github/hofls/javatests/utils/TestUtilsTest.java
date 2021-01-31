package com.github.hofls.javatests.utils;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestUtilsTest {

    @Test
    public void should_return_max_value() throws IOException {
        String expected = "hello world!";
        String actual = TestUtils.readFile(this.getClass(), "hello.txt");
        assertEquals(expected, actual);
    }

}
