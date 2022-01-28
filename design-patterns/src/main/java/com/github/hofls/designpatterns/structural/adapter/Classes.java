package com.github.hofls.designpatterns.structural.adapter;

public class Classes {

    public static class RestClient {
        public void sendTo(IRestServer restServer) {}
    }

    public interface IRestServer {
        void sendRestInfo();
    }

    public static class RestServer implements IRestServer {
        public void sendRestInfo() {}
    }

    public static class RestToSoapAdapter implements IRestServer {
        public void sendRestInfo() {
            new SoapServer().sendSoapInfo();
        }
    }

    public static class SoapServer {
        void sendSoapInfo() {}
    }

}
