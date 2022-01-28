package com.github.hofls.designpatterns.creational.abstract_factory;

/**
 * Abstract factory lets you produce families of related objects
 * Pattern is similar to Factory Method, but with emphasis on families of objects
 * Abstract factory is an object that has multiple factory methods on it
 */
public class Main {

    public void onStartup() {
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            buildUserInterface(new Factories.WindowsFactory());
        } else if (osName.contains("win")){
            buildUserInterface(new Factories.MacFactory());
        }
    }

    public void buildUserInterface(Factories.GuiFactory factory) {
        factory.createButton();
        factory.createCheckBox();
    }

}
