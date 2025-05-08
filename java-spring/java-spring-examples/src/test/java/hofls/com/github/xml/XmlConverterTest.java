package hofls.com.github.xml;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class XmlConverterTest {

    @Test
    public void should_convert_object_to_xml() throws Exception {
        String actualXml = XmlConverter.objectToXml(getPhoneObject());
        assertEquals(getPhoneXml(), actualXml);
    }

    @Test
    public void should_convert_xml_to_object() throws Exception {
        Smartphone expectedPhone = getPhoneObject();
        Smartphone actualPhone = XmlConverter.xmlToObject(getPhoneXml(), Smartphone.class);
        assertEquals(expectedPhone, actualPhone);
    }

    private Smartphone getPhoneObject() {
        Smartphone phone = new Smartphone();
        phone.setNumber("8-908-243-39-192");
        phone.setId(32423423);
        phone.setContacts(Arrays.asList("01", "02", "911"));
        return phone;
    }

    private String getPhoneXml() throws Exception {
        return IOUtils.toString(
                this.getClass().getResourceAsStream("phone.xml"),
                StandardCharsets.UTF_8
        );
    }

}
