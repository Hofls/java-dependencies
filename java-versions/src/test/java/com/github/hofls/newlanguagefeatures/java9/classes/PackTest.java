package com.github.hofls.newlanguagefeatures.java9.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PackTest {

    @Test
    void testName() {
        String expected = "com.github.hofls.newlanguagefeatures.java9.classes";
        assertEquals(expected, Pack.class.getPackageName());
    }
}
