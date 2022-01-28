package com.github.hofls.designpatterns.structural.delegation;

import org.springframework.util.StringUtils;

public class Classes {

    public static class TextUtils {

        public static boolean IsEmpty(String text) {
            return StringUtils.isEmpty(text);
        }

    }

}
