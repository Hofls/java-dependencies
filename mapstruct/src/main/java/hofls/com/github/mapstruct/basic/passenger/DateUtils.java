package hofls.com.github.mapstruct.basic.passenger;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/** When standard MapStruct types conversion is not enough */
public class DateUtils {

    public static LocalDateTime dateToDateTime(Date date) {
        if (date == null) {
            return null;
        }
        return LocalDateTime.ofInstant( date.toInstant(), ZoneId.systemDefault() );
    }

    public static Date dateTimeToDate(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        LocalDateTime localDateTime = LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault());
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

    }

}
