package com.github.hofls.lombok;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;


@Slf4j
public class LombokDemo {

    @Data
    @EqualsAndHashCode
    @ToString
    public static class Entity {
        private String text;
        private Integer number;
    }

    public static List<Integer> generateArray(@NonNull Integer arg) {
        var array = Arrays.asList(23, 43, 55);
        log.info("array is generated");
        return array;
    }

}
