package com.github.hofls.designpatterns.structural.facade;

/**
 * Facade provides a simplified interface to a complex set of classes
 */
public class Main {

    public void example() {
        Object video = new Object();
        Classes.VideoConverter converter = new Classes.VideoConverter();
        converter.convert(video);
    }

}
