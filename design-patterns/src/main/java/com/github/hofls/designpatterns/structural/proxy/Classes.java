package com.github.hofls.designpatterns.structural.proxy;

public class Classes {

    public static interface Converter {
        void convert();
    }

    public static class XmlConverter implements Converter {
        @Override
        public void convert() {}
    }

    public static class ProxyConverter implements Converter {
        @Override
        public void convert() {
            System.out.println("Convertion started!");
            new XmlConverter().convert();
        }
    }


}
