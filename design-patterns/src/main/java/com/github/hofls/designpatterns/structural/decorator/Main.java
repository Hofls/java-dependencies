package com.github.hofls.designpatterns.structural.decorator;

/**
 * Decorator (wrapper) allows you to add new behavior to objects dynamically
 */
public class Main {

    public void onStartup() {
        Classes.TextProcessorDecorator decorator = new Classes.TextProcessorDecorator();
        decorator.addProcessor(new Classes.CompressionProcessor());
        decorator.addProcessor(new Classes.EncryptionProcessor());
        decorator.process("Some text");
    }

}
