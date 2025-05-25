package com.example.kafka_consumer_app.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class KafkaMetrics {

    private final Counter eventCounter;

    public KafkaMetrics(MeterRegistry registry) {
        this.eventCounter = Counter.builder("user_events_processed")
                .description("Total number of user events processed")
                .register(registry);
    }

    public void increment() {
        eventCounter.increment();
    }
}
