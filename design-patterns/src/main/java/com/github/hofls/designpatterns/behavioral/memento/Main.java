package com.github.hofls.designpatterns.behavioral.memento;

/**
 * Memento lets you save and restore the previous state of an object
 */
public class Main {

    public void example() {
        Classes.History history = new Classes.History();
        Classes.State state = new Classes.State();
        history.addState(state);

        state.updateState("hello", 4L);
        history.addState(state);

        state.updateState("hello", 11L);
        history.addState(state);

        while (history.hasPrevious()) {
            Classes.State previousState = history.pollPrevious();
        }
    }

}
