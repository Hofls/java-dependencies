package com.github.hofls.lombok;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;


@Slf4j // generates logger field
public class LombokDemo {

    @Data // mutators, @EqualsAndHashCode, @ToString
    public static class Entity {
        private String text;
        private Integer number;
    }

    @Data
    @EqualsAndHashCode
    public static class Shop {
        @EqualsAndHashCode.Exclude
        private Integer id;
        private String address;
        private String description;
    }

    public static List<Integer> generateArray(@NonNull Integer arg) {
        var array = Arrays.asList(23, 43, 55);
        log.info("array is generated");
        return array;
    }

}
