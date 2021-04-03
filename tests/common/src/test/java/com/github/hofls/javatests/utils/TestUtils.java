package com.github.hofls.javatests.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.cxf.helpers.IOUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;

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
                    .writer()
                    .withDefaultPrettyPrinter();

    public static String readFile(Class clazz, String filename) throws IOException {
        return IOUtils.toString(clazz.getResourceAsStream(filename));
    }

    /** Converts objects to JSON and compares them */
    public static void assertEqualJson(Object expectedObj, Object actualObj)
            throws JsonProcessingException {
        assertEqualJson(expectedObj, actualObj, "");
    }

    /** Converts objects to JSON and compares them */
    public static void assertEqualJson(Object expectedObj, Object actualObj, String ignoredField)
            throws JsonProcessingException {
        String expectedJson = toLF(objectToJson(expectedObj));
        String actualJson = toLF(objectToJson(actualObj));
        expectedJson = removeLinesWithField(expectedJson, ignoredField);
        actualJson = removeLinesWithField(actualJson, ignoredField);
        assertEquals(expectedJson, actualJson);
    }

    private static String removeLinesWithField(String text, String ignoredField) {
        if (StringUtils.isEmpty(ignoredField)) {
            return text;
        }
        String ignored = "\"" + ignoredField + "\" :";

        StringBuilder builder = new StringBuilder();
        for (String line : text.split(LF)) {
            if (!line.contains(ignored)) {
                builder.append(line).append(LF);
            }
        }
        return builder.toString();
    }

    /** Replaces CRLF with LF */
    private static String toLF(String text) {
        return text.replaceAll(CRLF, LF);
    }

    public static String objectToJson(Object object) throws JsonProcessingException {
        if (object instanceof String) {
            return (String) object;
        } else {
            return objectWriter.writeValueAsString(object);
        }
    }
}
