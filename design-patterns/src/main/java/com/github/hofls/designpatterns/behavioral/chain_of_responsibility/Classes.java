package com.github.hofls.designpatterns.behavioral.chain_of_responsibility;

public class Classes {

    public interface Request {}

    public static abstract class Handler {
        Handler nextHandler = null;
        Handler setNext(Handler handler) {
            this.nextHandler = handler;
            return this.nextHandler;
        }
        void process(Request request) {}
    }


    public static class HeaderWriterFilter extends Handler {
        @Override
        public void process(Request request) {
            // some processing...
            nextHandler.process(request);
        }
    }

    public static class LogoutFilter extends Handler {
        @Override
        public void process(Request request) {
            // some processing...
            nextHandler.process(request);
        }
    }

    public static class AuthenticationFilter extends Handler {
        @Override
        public void process(Request request) {
            // some processing...
            nextHandler.process(request);
        }
    }

}
