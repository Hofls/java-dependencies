package com.github.hofls.designpatterns.creational.builder;

/**
 * Builder lets you construct complex objects step by step
 * Recognizeable by creational methods returning the instance itself
 */
public class Main {

    public void onStartup() {
        DocumentParts.Document document =
                new DocumentBuilder()
                .addHeader(new DocumentParts.Element())
                .addBody(new DocumentParts.Element())
                .addFooter(new DocumentParts.Element())
                .build();
    }
}
