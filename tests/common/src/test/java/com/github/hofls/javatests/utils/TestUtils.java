package com.github.hofls.javatests.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.cxf.helpers.IOUtils;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUtils {

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
        String expectedJson = objectToJson(expectedObj);
        String actualJson = objectToJson(actualObj);
        assertEquals(toLF(expectedJson), toLF(actualJson));
    }

    /** Replaces CRLF with LF */
    private static String toLF(String text){
        return text.replaceAll("\r\n", "\n");
    }

    public static String objectToJson(Object object) throws JsonProcessingException {
        if (object instanceof String) {
            return (String) object;
        } else {
            return objectWriter.writeValueAsString(object);
        }
    }
}
