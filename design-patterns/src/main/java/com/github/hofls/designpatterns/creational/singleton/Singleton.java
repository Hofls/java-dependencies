package com.github.hofls.designpatterns.creational.singleton;

public class Singleton {

    private Singleton() {}

    private static Object instance = null;

    public static Object getInstance() {
        if (instance == null) {
            instance = new Object();
        }
        return instance;
    }

}
