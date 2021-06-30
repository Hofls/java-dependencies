package com.github.hofls.javatests.utils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TestUtilsTest {

    @Test
    void should_return_max_value() throws IOException {
        String expected = "hello world!";
        String actual = TestUtils.readFile(this.getClass(), "hello.txt");
        assertEquals(expected, actual);
    }

    @Test
    void should_compare_json() throws IOException {
        Person expected = new Person(777, "John", LocalDate.of(2021, 6, 23));
        String actual = TestUtils.readFile(this.getClass(), "person.json");
        TestUtils.assertEqualJson(expected, actual, Arrays.asList("id"));
    }

    class Person {
        public int id;
        public String name;
        public LocalDate birthDate;

        public Person(int id, String name, LocalDate birthDate) {
            this.id = id;
            this.name = name;
            this.birthDate = birthDate;
        }
    }

}
