package com.github.hofls.rest.patch.common;

import java.util.UUID;

public interface Identifiable {

    UUID getId();

    void setId(UUID uuid);

}
