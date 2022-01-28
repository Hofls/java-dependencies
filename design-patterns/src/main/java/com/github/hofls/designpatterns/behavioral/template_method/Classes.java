package com.github.hofls.designpatterns.behavioral.template_method;

public class Classes {

    public abstract static class AbstractProcessor {
        public void process(String pathToFile) {
            openFile();
            parseFile();
            analyzeContent();
            closeFile();
        }
        protected abstract void openFile();
        protected abstract void parseFile();
        protected abstract void analyzeContent();
        protected abstract void closeFile();
    }

    public static class PdfProcessor extends AbstractProcessor {
        @Override
        protected void openFile() { }

        @Override
        protected void parseFile() { }

        @Override
        protected void analyzeContent() { }

        @Override
        protected void closeFile() { }
    }


    public static class CsvProcessor extends AbstractProcessor {
        @Override
        protected void openFile() { }

        @Override
        protected void parseFile() { }

        @Override
        protected void analyzeContent() { }

        @Override
        protected void closeFile() { }
    }

}
