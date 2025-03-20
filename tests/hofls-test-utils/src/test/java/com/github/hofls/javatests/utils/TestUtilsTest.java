package com.github.hofls.javatests.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.hofls.javatests.utils.dto.Person;
import com.github.hofls.test.utils.TestUtils;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TestUtilsTest {

    @Test
    void readFile() throws Exception {
        String expected = "hello world!";
        String actual = TestUtils.readFile(this.getClass(), "hello.txt");
        assertEquals(expected, actual);
    }

    @Test
    void assertEqualJson() throws Exception {
        List<String> list = Arrays.asList("SOME TEXT A", "SOME TEXT B", "SOME TEXT C");
        LocalDate date = LocalDate.of(2021, 6, 23);
        Person expected = new Person(777, "John", date, list);
        String actual = TestUtils.readFile(this.getClass(), "assertEqualJson.json");
        TestUtils.assertEqualJson(expected, actual, Arrays.asList("id"));
    }

    @Test
    void readObjectFromFile() throws Exception {
        String expected = TestUtils.readFile(this.getClass(), "person.json");
        Person actual = TestUtils.readObjectFromFile(this.getClass(), "person.json", Person.class);
        TestUtils.assertEqualJson(expected, actual);
    }

    @Test
    void readListFromFile() throws Exception {
        String expected = TestUtils.readFile(this.getClass(), "people.json");
        Person[] peopleArray = TestUtils.readObjectFromFile(this.getClass(), "people.json", Person[].class);
        List<Person> peopleList = Arrays.stream(peopleArray).collect(Collectors.toList());
        TestUtils.assertEqualJson(expected, peopleList);
    }

    @Test
    void jsonToObject() throws Exception {
        String expected = TestUtils.readFile(this.getClass(), "person.json");
        Person actual = TestUtils.jsonToObject(expected, Person.class);
        TestUtils.assertEqualJson(expected, actual);
    }

    @Test
    void jsonToMap() throws Exception {
        String jsonText = TestUtils.readFile(this.getClass(), "person.json");
        JsonNode jsonMap = TestUtils.jsonToMap(jsonText);
        assertEquals("754342", jsonMap.get("id").asText());
        assertEquals("2021-06-23", jsonMap.get("birthDate").asText());
    }

    @Test
    public void assertPrettyEqual(){
        String actual = "{\"msg\": \"Hello!\", \"id\": 543719, \"async\": true}";
        String expected = "{\"async\": true, \"msg\": \"Hello!\", \"id\": 19483}";
        TestUtils.assertPrettyEqual(expected, actual, Arrays.asList("id"));
    }

}
