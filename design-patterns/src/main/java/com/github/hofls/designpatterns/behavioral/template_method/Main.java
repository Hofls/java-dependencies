package com.github.hofls.designpatterns.behavioral.template_method;

import java.util.Arrays;
import java.util.List;

/**
 * Template method - defines the skeleton of an algorithm in the superclass but lets
 * subclasses override specific steps of the algorithm without changing its structure.
 */
public class Main {

    public void onStartup() {
        List<Classes.AbstractProcessor> processors = Arrays.asList(
                new Classes.CsvProcessor(),
                new Classes.PdfProcessor()
        );
        for (Classes.AbstractProcessor processor : processors) {
            processor.process("/opt/files/something.wt");
        }
    }

}
