package com.github.hofls.designpatterns.structural.composite;


/**
 * lets you compose objects into tree structures of simple and composite objects
 */
public class Main {

    public void onStartup() {
        Classes.Directory directoryB = new Classes.Directory();
        directoryB.addElement(new Classes.File());

        Classes.Directory directoryA = new Classes.Directory();
        directoryA.addElement(new Classes.File());
        directoryA.addElement(directoryB);
    }

}
