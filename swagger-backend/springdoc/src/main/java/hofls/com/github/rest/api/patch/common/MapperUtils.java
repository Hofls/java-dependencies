package hofls.com.github.rest.api.patch.common;

import java.util.UUID;


public class MapperUtils {

    public static UUID toUUID(String value) {
        return UUID.fromString(value);
    }

}
