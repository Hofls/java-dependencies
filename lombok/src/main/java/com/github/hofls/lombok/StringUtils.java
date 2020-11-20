package ru.emias.mobile.doctor.server.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class StringUtils {

    public boolean isEmpty(String value) {
        return value == null || "".equals(value);
    }

}
