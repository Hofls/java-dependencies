package hofls.com.github.xml;

import javax.xml.bind.JAXB;
import java.io.StringReader;
import java.io.StringWriter;

public class XmlConverter {

    public static String objectToXml(Object object) {
        StringWriter sw = new StringWriter();
        JAXB.marshal(object, sw);
        return sw.toString();
    }

    public static <T> T xmlToObject(String xml, Class<T> clazz)  {
        return JAXB.unmarshal(new StringReader(xml), clazz);
    }

}
