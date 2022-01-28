package com.github.hofls.designpatterns.behavioral.observer;

/**
 * Observer defines subscription mechanism to notify listeners about events that happen to the object they're observing
 */
public class Main {

    public void onStartup() {
        Classes.EventManager eventManager = new Classes.EventManager();
        eventManager.addListener(new Classes.EventListener());
        eventManager.addListener(new Classes.EventListener());
        eventManager.notify("Something happened!");
    }

}
