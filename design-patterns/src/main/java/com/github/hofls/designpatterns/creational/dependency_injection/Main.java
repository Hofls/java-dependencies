package com.github.hofls.designpatterns.creational.dependency_injection;

import java.util.Arrays;
import java.util.List;

/**
 * Dependency injection is a technique whereby one object supplies the dependencies of another object.
 * Based on "Inversion Of Control"
 */
public class Main {

    public void onStartup() {
        List<DependencyInjection.MailClient> mailClients = Arrays.asList(
                new DependencyInjection.RotatingVpnClient(),
                new DependencyInjection.ExtraFastClient()
        );

        for (DependencyInjection.MailClient client : mailClients) {
            DependencyInjection.SpamBot bot = new DependencyInjection.SpamBot(client);
            bot.sendSpam();
        }
    }

}
