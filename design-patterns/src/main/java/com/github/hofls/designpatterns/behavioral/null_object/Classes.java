package com.github.hofls.designpatterns.behavioral.null_object;

public class Classes {

    public static interface ConsoleWriter {
        void write(String text);
    }

    public static class ClassicWriter implements ConsoleWriter {

        public void write(String text) {
            System.out.println(text);
        }

    }

    public static class NullWriter implements ConsoleWriter {

        public void write(String text) {}

    }

}
