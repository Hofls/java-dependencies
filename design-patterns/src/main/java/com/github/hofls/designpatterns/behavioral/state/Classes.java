package com.github.hofls.designpatterns.behavioral.state;

public class Classes {

    interface State {
        void pull(Oven wrapper);
    }

    public static class Oven {
        private State currentState;

        public Oven() {
            currentState = new Off();
        }

        public void set_state(State s) {
            currentState = s;
        }

        public void pull() {
            currentState.pull(this);
        }
    }

    public static class Off implements State {
        public void pull(Oven wrapper) {
            wrapper.set_state(new Low());
            System.out.println("Oven at low temperature");
        }
    }

    public static class Low implements State {
        public void pull(Oven wrapper) {
            wrapper.set_state(new High());
            System.out.println("Oven at high temperature");
        }
    }

    public static class High implements State {
        public void pull(Oven wrapper) {
            wrapper.set_state(new Off());
            System.out.println("Oven is off");
        }
    }



}
