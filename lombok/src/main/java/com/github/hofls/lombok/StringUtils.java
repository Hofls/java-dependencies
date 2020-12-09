package com.github.hofls.lombok;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringUtils {

    public boolean isEmpty(String value) {
        return value == null || "".equals(value);
    }

}
