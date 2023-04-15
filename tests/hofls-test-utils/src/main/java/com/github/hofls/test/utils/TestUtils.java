package com.github.hofls.test.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.cxf.helpers.IOUtils;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
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
    private static final ObjectMapper objectMapper = getObjectMapper();
    private static final ObjectWriter objectWriter = getObjectWriter();

    private static ObjectMapper getObjectMapper() {
        return new ObjectMapper()
                .configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true)
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .registerModule(new JavaTimeModule())
                .registerModule(getOffsetDateTimeModule());
    }

    private static ObjectWriter getObjectWriter() {
        CustomPrinter prettyPrinter = new CustomPrinter();
        // var prettyPrinter = new DefaultPrettyPrinter();
        // prettyPrinter.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);
        prettyPrinter.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE); // each list element in new line
        return getObjectMapper().writer().with(prettyPrinter);
    }

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
            String expectedJson = toLF(objectToJson(expectedObj, ignoredFields));
            String actualJson = toLF(objectToJson(actualObj, ignoredFields));
            assertEquals(expectedJson, actualJson);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T readObjectFromFile(Class resourceFromClass, String filename, Class<T> clazz) throws IOException {
        return objectMapper.readValue(IOUtils.toString(resourceFromClass.getResourceAsStream(filename)), clazz);
    }

    public static <T> T jsonToObject(String json, Class<T> clazz)  throws JsonProcessingException {
        return objectMapper.readValue(json, clazz);
    }

    public static JsonNode jsonToMap(String json) {
        try {
            return new ObjectMapper().readTree(json);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String objectToJson(Object object, List<String> ignoredFields) {
        try {
            if (object instanceof String) {
                return (String) object;
            } else {
                String json = objectWriter.writeValueAsString(object);
                JsonNode jsonNode = new ObjectMapper().readTree(json);
                removeFields(jsonNode, ignoredFields);

                return objectWriter.writeValueAsString(jsonNode);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static JsonNode removeFields(JsonNode node, List<String> ignoredFields) {
        if (node.isArray()) {
            for (JsonNode child : node) {
                removeFields(child, ignoredFields);
            }
        } else if (node.isObject()) {
            ObjectNode objectNode = (ObjectNode) node;
            objectNode.remove(ignoredFields);
            for (JsonNode child : node) {
                removeFields(child, ignoredFields);
            }
        }
        return node;
    }

    // -----------------------------------------------------------------------------

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
            String ignored = "\"" + ignoredField + "\":";
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

    /** Without this module - Windows and Linux will have different date formats */
    private static SimpleModule getOffsetDateTimeModule() {
        SimpleModule module = new SimpleModule();
        module.addSerializer(OffsetDateTime.class, new JsonSerializer<OffsetDateTime>() {
            @Override
            public void serialize(OffsetDateTime offsetDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
                jsonGenerator.writeString(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(offsetDateTime));
            }
        });
        return module;
    }

    public static class CustomPrinter extends DefaultPrettyPrinter {
        public CustomPrinter() {
            this.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);
        }

        @Override
        public DefaultPrettyPrinter createInstance() {
            return new CustomPrinter();
        }

        @Override
        public void writeObjectFieldValueSeparator(JsonGenerator jg) throws IOException {
            jg.writeRaw(": ");
        }
    }

}
