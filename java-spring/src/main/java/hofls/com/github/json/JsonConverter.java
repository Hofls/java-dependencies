package hofls.com.github.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * For more methods to work with json, look at ParametersUtils in "test-containers-postgres"
 * @see hofls.com.github.junit.TestUtils
 */
public class JsonConverter {

    private static ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    private static ObjectWriter objectWriter = mapper.writer().withDefaultPrettyPrinter();

    public static String objectToJson(Object object) throws JsonProcessingException {
        return objectWriter.writeValueAsString(object);
    }

    public static <T> T jsonToObject(String json, Class<T> clazz)  throws JsonProcessingException {
        return mapper.readValue(json, clazz);
    }

    public static JsonNode jsonToMap(String json) {
        try {
            return new ObjectMapper().readTree(json);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
