package hofls.com.github.utils;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.GregorianCalendar.from;
import static java.util.GregorianCalendar.getInstance;

public final class DateUtils {

    public static OffsetDateTime toDayStart(OffsetDateTime date) {
        return date.withHour(0).withMinute(0).withSecond(0).withNano(0);
    }

    public static LocalDateTime toLocalDateTime(LocalDate date) {
        return LocalDateTime.of(date, LocalTime.MIN);
    }

    public static LocalDateTime toDayStart(LocalDateTime date) {
        return date.with(LocalTime.MIN);
    }

    public static LocalDateTime toDayEnd(LocalDateTime date) {
        return date.with(LocalTime.MAX);
    }

    public static Date toDayStart(Date date) {
        Calendar calendar = getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date toDayEnd(Date date) {
        Calendar calendar = getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    public static Date addDays(Date date, int days) {
        Calendar calendar = getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return calendar.getTime();
    }

    public static Date toDate(XMLGregorianCalendar xmlGregorianCalendar) {
        if (xmlGregorianCalendar != null) {
            return xmlGregorianCalendar.toGregorianCalendar().getTime();
        }
        return null;
    }

    public static Date toDate(LocalDate dateToConvert) {
        if (dateToConvert == null) {
            return null;
        }

        return Date.from(
                dateToConvert.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate toLocalDate(XMLGregorianCalendar xmlGregorianCalendar) {
        if (xmlGregorianCalendar != null) {
            return xmlGregorianCalendar.toGregorianCalendar().toZonedDateTime().toLocalDate();
        } else {
            return null;
        }
    }

    public static LocalDate toLocalDate(Date date) {
        if (date != null) {
            return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
        return null;
    }

    public static XMLGregorianCalendar toXmlCalendar(LocalDate localDate) {
        try {
            GregorianCalendar gcal = from(localDate.atStartOfDay(ZoneId.systemDefault()));
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
        } catch (Exception e) {
            return null;
        }
    }

    public static XMLGregorianCalendar toXmlCalendar(Date date) {
        try {
            GregorianCalendar c = new GregorianCalendar();
            c.setTime(date);
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        } catch (Exception e) {
            return null;
        }
    }

    public static XMLGregorianCalendar toXmlCalendar(LocalDateTime localDateTime) {
        try {
            GregorianCalendar gcal = from(localDateTime.atZone(ZoneId.systemDefault()));
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
        } catch (Exception e) {
            return null;
        }
    }

    public static LocalDateTime toLocalDateTime(
            XMLGregorianCalendar xmlGregorianCalendar) {
        if (xmlGregorianCalendar != null) {
            return xmlGregorianCalendar
                    .toGregorianCalendar()
                    .getTime()
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
        }
        return null;
    }

    public static LocalDateTime toLocalDateTime(Date dateToConvert) {
        if (dateToConvert == null) {
            return null;
        }
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    // Example format - "dd.MM.yyyy"
    public static String format(LocalDate date, String format) {
        if (date == null) {
            return "";
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return date.format(formatter);
    }

    public static String format(Date date, String format) {
        if (date == null) {
            return "";
        }
        Format formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

    public static String toString(Date date) {
        if (date == null) {
            return "";
        }
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    public static long differenceDays(Date start, Date end) {
        long millis = end.getTime() - start.getTime();
        return TimeUnit.DAYS.convert(millis, TimeUnit.MILLISECONDS);
    }

}
