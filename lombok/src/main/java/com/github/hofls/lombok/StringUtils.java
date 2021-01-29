package com.github.hofls.lombok;

import lombok.experimental.UtilityClass;

@UtilityClass // empty constructor, everything becomes static
public class StringUtils {

    public boolean isEmpty(String value) {
        return value == null || "".equals(value);
    }

}
