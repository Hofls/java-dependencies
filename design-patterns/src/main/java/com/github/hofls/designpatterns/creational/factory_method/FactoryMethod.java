package com.github.hofls.designpatterns.creational.factory_method;

public class FactoryMethod {

    public interface ImageReader {
        DecodedImage decodeImage(String encodedImage);
    }

    public interface DecodedImage {}

    public static class SvgImage implements DecodedImage {}

    public static class PngImage implements DecodedImage {}

    public static class SvgReader implements ImageReader {
        @Override
        public DecodedImage decodeImage(String encodedImage) {
            return new SvgImage();
        }
    }

    public static class PngReader implements ImageReader {
        @Override
        public DecodedImage decodeImage(String encodedImage) {
            return new PngImage();
        }
    }

}
