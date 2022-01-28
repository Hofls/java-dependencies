package com.github.hofls.designpatterns.behavioral.mediator;

/**
 * Mediator restricts direct communications between the objects and forces them to collaborate only via a mediator object
 */
public class Main {

    public void onStartup() {
        Classes.Mediator mediator = new Classes.Mediator();
        new Classes.Producer().produce(mediator);
        new Classes.Consumer().consume(mediator);
    }

}
