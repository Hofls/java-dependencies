package com.github.hofls.javatests.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateTest {

    @Test
    void date_test()  {
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/London"));
        // ^ is a must for date comparison

        Date date = new Date(120, Calendar.JANUARY, 23);
        LocalDate actualDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();;
        LocalDate expectedDate = LocalDate.of(2020, 1, 23);
        assertEquals(expectedDate, actualDate);
    }

}
