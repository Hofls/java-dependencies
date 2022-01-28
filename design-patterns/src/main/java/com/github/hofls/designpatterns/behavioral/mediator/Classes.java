package com.github.hofls.designpatterns.behavioral.mediator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Classes {

    public static class Mediator implements Iterator<String> {
        Queue<String> messages = new LinkedList<>();

        public void addMessage(String message) {
            messages.add(message);
        }

        @Override
        public boolean hasNext() {
            return messages.size() > 0;
        }

        @Override
        public String next() {
            return messages.poll();
        }
    }

    public static class Producer {
        public void produce(Mediator mediator) {
            for (int i = 0; i < 10; i++) {
                mediator.addMessage("New message!");
            }
        }
    }

    public static class Consumer {
        public void consume(Mediator mediator) {
            while (mediator.hasNext()) {
                String message = mediator.next();
            }
        }
    }

}
