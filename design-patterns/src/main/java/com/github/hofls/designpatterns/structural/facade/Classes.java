package com.github.hofls.designpatterns.structural.facade;

public class Classes {

    public static class AudioMixer {
        public static void mix(Object video) {}
    }

    public static class BitrateReader {
        public static void read(Object video) {}
    }

    public static class CompressionCoder {
        public static void apply(Object video) {}
    }


    public static class VideoConverter {

        public Object convert(Object video) {
            AudioMixer.mix(video);
            BitrateReader.read(video);
            CompressionCoder.apply(video);
            return video;
        }

    }

}
