package com.github.hofls.designpatterns.structural.adapter;

/**
 * Adapter allows objects with incompatible interfaces to collaborate.
 * Useful when you cant change object interface (e.g. it comes as external dependency)
 */
public class Main {

    public void onStartup() {
        Classes.RestClient client = new Classes.RestClient();
        client.sendTo(new Classes.RestServer());
        client.sendTo(new Classes.RestToSoapAdapter());
    }

}
