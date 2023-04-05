package com.github.hofls.javatests.utils;

import com.github.hofls.test.utils.TestUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TestUtilsTest {

    /** Make sure that TestUtils is working */
    @Test
    void smoke_test() throws IOException {
        String expected = "hello world!";
        String actual = TestUtils.readFile(this.getClass(), "hello.txt");
        assertEquals(expected, actual);
    }

}
