package hofls.com.github.utils;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;

public class TextUtils {

    public static String remove(String text, Collection<String> removeList) {
        if (org.springframework.util.StringUtils.isEmpty(text)
                || CollectionUtils.isEmpty(removeList)) {
            return text;
        }

        for (var removeElem : removeList) {
            text = text.replace(removeElem, "");
        }
        return text;
    }

    public static String replace(String text, String oldValue, String newValue) {
        if (org.springframework.util.StringUtils.isEmpty(text)
                || org.springframework.util.StringUtils.isEmpty(oldValue)) {
            return text;
        }

        var newValueFixed = newValue == null ? "" : newValue;
        return text.replace(oldValue, newValueFixed);
    }

    public static boolean allEmpty(String... values) {
        for (var value : values) {
            if (!org.springframework.util.StringUtils.isEmpty(value)) {
                return false;
            }
        }

        return true;
    }

    public static boolean anyEmpty(String... values) {
        for (var value : values) {
            if (org.springframework.util.StringUtils.isEmpty(value)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isTrimmedEmpty(String value) {
        if (value == null) {
            return true;
        }

        var withoutZeroWidth = value.replaceAll("\\u200B", "");
        return org.springframework.util.StringUtils.isEmpty(
                org.springframework.util.StringUtils.trimWhitespace(withoutZeroWidth));
    }

    public static boolean isNotTrimmedEmpty(String value) {
        return !isTrimmedEmpty(value);
    }

    public static String substringBetween(String text, String start, String end) {
        return text.substring(text.indexOf(start) + 1, text.indexOf(end));
    }

    public static String emptyToNull(String text) {
        if (org.apache.cxf.common.util.StringUtils.isEmpty(text)) {
            return null;
        } else {
            return text;
        }
    }

    public static String firstNotEmpty(List<String> texts) {
        if (CollectionUtils.isEmpty(texts)) return null;
        return texts.stream().filter(s -> !isTrimmedEmpty(s)).findFirst().orElse(null);
    }

}
