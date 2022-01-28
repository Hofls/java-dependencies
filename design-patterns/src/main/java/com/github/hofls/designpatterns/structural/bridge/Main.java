package com.github.hofls.designpatterns.structural.bridge;

import java.util.Arrays;
import java.util.List;

/**
 * Bridge separates an object's interface from its implementation
 * Usually designed up-front, letting you develop parts of an application independently of each other
 */
public class Main {

    public void onStartup() {
        List<Classes.Document> documents =
                Arrays.asList(new Classes.CasualDocument(), new Classes.SpecialDocument());
        List<Classes.DocumentProcessor> processors =
                Arrays.asList(new Classes.HashProcessor(), new Classes.AvgProcessor());
        processors.forEach(processor -> documents.forEach(processor::process));
    }

}
