package hofls.com.github.rest.patch.common;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;


public class PatchMapperUtils {

    public static UUID toUUID(String value) {
        return value.equals("") ? null : UUID.fromString(value);
    }

    public static Boolean toBoolean(String value) {
        return value.equals("") ? null : Boolean.valueOf(value);
    }

    public static Integer toInteger(String value) {
        return value.equals("") ? null : Integer.valueOf(value);
    }

    public static Long toLong(String value) {
        return value.equals("") ? null : Long.valueOf(value);
    }

    public static Double toDouble(String value) {
        return value.equals("") ? null : Double.valueOf(value);
    }

    public static LocalDate toLocalDate(String value) {
        return value.equals("") ? null : LocalDate.parse(value);
    }

    public static LocalTime toLocalTime(String value) {
        return value.equals("") ? null : LocalTime.parse(value, DateTimeFormatter.ofPattern("HH:mm"));
    }

}
