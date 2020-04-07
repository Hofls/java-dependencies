package hofls.com.github.json;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class JsonConverterTest {

    @Test
    public void should_convert_object_to_json() throws Exception {
        Phone phone = getPhoneObject();
        String actualJson = JsonConverter.objectToJson(phone);
        String expectedJson = getPhoneJson();
        Assert.assertEquals(expectedJson, actualJson);
    }

    @Test
    public void should_convert_json_to_object() throws Exception {
        Phone expectedPhone = getPhoneObject();
        Phone actualPhone = JsonConverter.jsonToObject(getPhoneJson(), Phone.class);
        Assert.assertEquals(expectedPhone, actualPhone);
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
