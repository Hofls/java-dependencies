package hofls.com.github;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class JsonConverter {

    private static ObjectMapper mapper = new ObjectMapper();
    private static ObjectWriter objectWriter = mapper.writer();

    public static String objectToJson(Object object) {
        try {
            return objectWriter.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T jsonToObject(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}