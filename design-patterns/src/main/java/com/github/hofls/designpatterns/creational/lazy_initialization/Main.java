package com.github.hofls.designpatterns.creational.lazy_initialization;

/**
 * Lazy initialization is the tactic of delaying object creation until the first time it is needed
 */
public class Main {

    public void onStartup() {
        Initialization.Eager eager = new Initialization.Eager();
        Initialization.Lazy lazy = new Initialization.Lazy();
    }

}
