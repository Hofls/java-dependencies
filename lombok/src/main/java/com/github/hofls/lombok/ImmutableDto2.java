package com.github.hofls.lombok;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder
@FieldNameConstants // Access field names, e.g. ImmutableDto2.Fields.name (alternative to hibernate-jpamodelgen)
public class ImmutableDto2 {
    Long id;
    String name;
}
