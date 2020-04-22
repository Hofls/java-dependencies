package com.github.redis;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

@Component
public class OnStartup {


    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        dataStorageDemo();
        messageQueueDemo();
    }

    private void dataStorageDemo() {
        Jedis jedis = new Jedis();
        jedis.set("some_message", "Hello World!");
        String cachedResponse = jedis.get("some_message");
        System.out.println("Stored value: " + cachedResponse);
    }

    private void messageQueueDemo() {
        new Thread(this::subscribe).start();
        new Thread(this::publish).start();
    }

    private void subscribe() {
        Jedis jSubscriber = new Jedis();
        jSubscriber.subscribe(new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                System.out.println("Message from queue: " + message);
            }
        }, "channel");
    }

    private void publish()  {
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {}
        Jedis jPublisher = new Jedis();
        jPublisher.publish("channel", "test message");
    }


}
