package hofls.com.github.json;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonConverterTest {

    @Test
    void should_convert_object_to_json() throws Exception {
        Phone phone = getPhoneObject();
        String actualJson = JsonConverter.objectToJson(phone);
        String expectedJson = getPhoneJson();
        assertEquals(expectedJson, actualJson);
    }

    @Test
    void should_convert_json_to_object() throws Exception {
        Phone expectedPhone = getPhoneObject();
        Phone actualPhone = JsonConverter.jsonToObject(getPhoneJson(), Phone.class);
        assertEquals(expectedPhone, actualPhone);
    }

    @Test
    void should_convert_json_to_map() throws Exception {
        JsonNode jsonMap = JsonConverter.jsonToMap(getPhoneJson());
        assertEquals("32423423", jsonMap.get("id").asText());
        assertEquals("8-908-243-39-192", jsonMap.get("number").asText());
    }

    private Phone getPhoneObject() {
        Phone phone = new Phone();
        phone.setNumber("8-908-243-39-192");
        phone.setId(32423423);
        phone.setContacts(Arrays.asList("01", "02", "911"));
        return phone;
    }

    private String getPhoneJson() throws Exception {
        return IOUtils.toString(
                this.getClass().getResourceAsStream("phone.json"),
                StandardCharsets.UTF_8
        );
    }

}
