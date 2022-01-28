package com.github.hofls.designpatterns.creational.lazy_initialization;

public class Initialization {

    public static class Eager {
        private Object resource = new Object();

        Object getResource() {
            return resource;
        }
    }

    public static class Lazy {
        private Object resource = null;

        Object getResource() {
            if (resource == null) {
                resource = new Object();
            }
            return resource;
        }
    }


}
