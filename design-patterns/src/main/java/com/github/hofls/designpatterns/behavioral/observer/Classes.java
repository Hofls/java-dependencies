package com.github.hofls.designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Classes {

    public static class EventManager {
        List<EventListener> listeners = new ArrayList<>();

        public void addListener(EventListener listener) {
            listeners.add(listener);
        }

        public void notify(String event) {
            for (EventListener listener : listeners) {
                listener.notify();
            }
        }
    }

    public static class EventListener {
        public void onEvent() {}
    }

}
