package com.github.hofls.lombok;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder
public class ImmutableDto2 {
    Long id;
    String name;
}
