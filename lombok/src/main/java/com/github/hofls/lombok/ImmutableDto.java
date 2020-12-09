package com.github.hofls.lombok;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value // adds "private final" to the fields; generates getters, equals/hashcode, toString
@Builder // generates chainable methods
public class ImmutableDto {
    Long id;
    String description;
    LocalDate startDate;
}
