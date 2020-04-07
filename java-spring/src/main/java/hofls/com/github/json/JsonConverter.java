package hofls.com.github.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class JsonConverter {

    private static ObjectMapper mapper = new ObjectMapper();
    private static ObjectWriter objectWriter = mapper.writer().withDefaultPrettyPrinter();

    public static String objectToJson(Object object) throws JsonProcessingException {
        return objectWriter.writeValueAsString(object);
    }

    public static <T> T jsonToObject(String json, Class<T> clazz)  throws JsonProcessingException {
        return mapper.readValue(json, clazz);
    }

}
