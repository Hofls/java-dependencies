package com.github.hofls.metrics;

import com.github.hofls.rest.ShopController;
import io.micrometer.core.instrument.Counter;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
@RequiredArgsConstructor
public class LiveTestService {

    private final PrometheusMeterRegistry prometheusMeterRegistry;
    private final ShopController shopController;
    private Counter businessEndpointCounterTotal;
    private Counter businessEndpointCounterFailure;

    @PostConstruct
    public void init() {
        businessEndpointCounterTotal = prometheusMeterRegistry.counter("liveTest." + ShopController.BUSINESS_ENDPOINT + ".all.total");
        businessEndpointCounterFailure = prometheusMeterRegistry.counter("liveTest." + ShopController.BUSINESS_ENDPOINT + ".failure.total");
    }

    // If 20 different methods are scheduled for execution, each will be executed in its own thread without problems?
    // Nope, by default only 1 thread for scheduled, while this method executes, all other scheduled methods wait for their turn
    // To run multiple scheduled methods at the same time add to application.properties - spring.task.scheduling.pool.size=10
    @Scheduled(initialDelayString = "${live-test.initialDelay}", fixedRateString = "${live-test.fixedRate}")
    // fixedRate = old one still running? dont care, run new one
    // fixedDelay = wait for old one to finish, delay, run new one
    public void liveTest() {
        try {
            shopController.findProduct();
        } catch (Exception ex) {
            log.info("liveTest Failure: " + ex.getMessage());
            businessEndpointCounterFailure.increment();
        } finally {
            businessEndpointCounterTotal.increment();
        }
    }
}
