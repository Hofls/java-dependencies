package com.github.hofls.designpatterns.creational.dependency_injection;

public class DependencyInjection {

    public interface MailClient {
        void sendEmail();
    }

    public static class RotatingVpnClient implements MailClient {
        public void sendEmail() {}
    }

    public static class ExtraFastClient implements MailClient {
        public void sendEmail() {}
    }

    public static class SpamBot {
        private MailClient client = null;
        public SpamBot(MailClient client) {
            this.client = client;
        }

        public void sendSpam() {
            client.sendEmail();
        }
    }


}
