package com.github.hofls.designpatterns.structural.decorator;

import java.util.ArrayList;
import java.util.List;

public class Classes {

    public interface TextProcessor {
        String process(String text);
    }

    public static class EncryptionProcessor implements TextProcessor {
        @Override
        public String process(String text) {
            return text;
        }
    }

    public static class CompressionProcessor implements TextProcessor {
        @Override
        public String process(String text) {
            return text;
        }
    }

    public static class TextProcessorDecorator implements TextProcessor {
        private List<TextProcessor> processors = new ArrayList<>();

        public void addProcessor(TextProcessor processor) {
            processors.add(processor);
        }

        @Override
        public String process(String text) {
            String result = text;
            for (TextProcessor processor : processors)  {
                result = processor.process(result);
            }
            return result;
        }
    }

}
