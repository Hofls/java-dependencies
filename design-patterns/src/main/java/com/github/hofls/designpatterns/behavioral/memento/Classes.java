package com.github.hofls.designpatterns.behavioral.memento;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

public class Classes {

    public static class State implements Serializable {
        private String text;
        private Long cursorPosition;
        public void updateState(String text, Long cursorPosition) {
            this.text = text;
            this.cursorPosition = cursorPosition;
        }
    }

    public static class History {
        public Queue<State> mementos = new LinkedList<>();

        public void addState(State state) {
            State clonedState = SerializationUtils.clone(state);
            mementos.add(clonedState);
        }

        public boolean hasPrevious() {
            return mementos.size() > 0;
        }

        public State pollPrevious() {
            return mementos.poll();
        }
    }

}
