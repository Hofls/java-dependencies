package com.github.hofls.designpatterns.behavioral.state;

/**
 * State - alters object behavior when its state changes
 */
public class Main {

    public void onStartup() {
        Classes.Oven oven = new Classes.Oven();
        oven.pull();
    }

}
