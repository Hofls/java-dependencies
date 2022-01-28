package com.github.hofls.designpatterns.creational.prototype;

import org.apache.commons.lang3.SerializationUtils;

/**
 * Prototype (aka Clone) lets you copy existing objects
 */
public class Main {

    public void onStartup() {
        SerializationUtils.clone(new Long("23"));
    }

}
