package com.github.hofls.javatests.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.cxf.helpers.IOUtils;
import org.springframework.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Why use json to compare objects?
 * No need to write/read/maintain a bunch of asserts in code.
 * JSON comparison shows entire object diff.
 * Somebody added new field to object, but forgot about tests?
 * No problem, tests will remind about themself by failing.
 */
public class TestUtils {

    private static final String CRLF = "\r\n";
    private static final String LF = "\n";
    private static final ObjectWriter objectWriter =
            new ObjectMapper()
                    .configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true)
                    .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                    .registerModule(new JavaTimeModule())
                    .writer()
                    .withDefaultPrettyPrinter();

    /**
     * To generate file in 'resources' folder (IntelliJ IDEA)
     * 1. Add annotation "@Sql("expectedFile.json")"
     * 2. Select annotation, press Alt+Enter
     * */
    public static String readFile(Class clazz, String filename) {
        try {
            return IOUtils.toString(clazz.getResourceAsStream(filename));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /** Converts objects to JSON and compares them */
    public static void assertEqualJson(Object expectedObj, Object actualObj) {
        assertEqualJson(expectedObj, actualObj, new ArrayList<>());
    }

    /** Converts objects to JSON and compares them */
    public static void assertEqualJson(Object expectedObj, Object actualObj, List<String> ignoredFields) {
        try {
            String expectedJson = toLF(objectToJson(expectedObj));
            String actualJson = toLF(objectToJson(actualObj));
            expectedJson = removeLinesWithField(expectedJson, ignoredFields);
            actualJson = removeLinesWithField(actualJson, ignoredFields);
            assertEquals(expectedJson, actualJson);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String removeLinesWithField(String text, List<String> ignoredFields) {
        if (CollectionUtils.isEmpty(ignoredFields)) {
            return text;
        }

        StringBuilder builder = new StringBuilder();
        for (String line : text.split(LF)) {
            if (!isLineIgnored(line, ignoredFields)) {
                builder.append(line).append(LF);
            }
        }
        return builder.toString();
    }

    private static boolean isLineIgnored(String line, List<String> ignoredFields) {
        if (CollectionUtils.isEmpty(ignoredFields)) {
            return false;
        }

        for (String ignoredField : ignoredFields) {
            String ignored = "\"" + ignoredField + "\" :";
            if (line.contains(ignored)) {
                return true;
            }
        }
        return false;
    }

    /** Replaces CRLF with LF */
    private static String toLF(String text) {
        return text.replaceAll(CRLF, LF);
    }

    public static String objectToJson(Object object) {
        try {
            if (object instanceof String) {
                return (String) object;
            } else {
                return objectWriter.writeValueAsString(object);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
