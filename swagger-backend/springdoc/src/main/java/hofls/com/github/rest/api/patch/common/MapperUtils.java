package hofls.com.github.rest.api.patch.common;

import java.time.LocalDate;
import java.util.UUID;


public class MapperUtils {

    public static UUID toUUID(String value) {
        return UUID.fromString(value);
    }

    public static Long toLong(String value) {
        return value.equals("") ? null : Long.valueOf(value);
    }

    public static LocalDate toLocalDate(String value) {
        return value.equals("") ? null : LocalDate.parse(value);
    }

}
