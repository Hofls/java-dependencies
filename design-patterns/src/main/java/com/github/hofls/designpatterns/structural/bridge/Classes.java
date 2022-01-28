package com.github.hofls.designpatterns.structural.bridge;

public class Classes {

    public interface Document {}

    public static class CasualDocument implements Document {}

    public static class SpecialDocument implements Document {}

    public interface DocumentProcessor {
        void process(Document document);
    }

    public static class HashProcessor implements DocumentProcessor {
        @Override
        public void process(Document document) {
        }
    }

    public static class AvgProcessor implements DocumentProcessor {
        @Override
        public void process(Document document) {
        }
    }

}
