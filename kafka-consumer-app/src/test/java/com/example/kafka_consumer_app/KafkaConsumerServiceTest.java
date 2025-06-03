package com.example.kafka_consumer_app;

import com.example.kafka_consumer_app.entity.UserEvent;
import com.example.kafka_consumer_app.metrics.KafkaMetrics;
import com.example.kafka_consumer_app.service.KafkaConsumerService;
import com.example.kafka_consumer_app.service.UserEventService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class KafkaConsumerServiceTest {

    @InjectMocks
    private KafkaConsumerService consumer;

    @Mock
    private UserEventService userEventService;

    @Mock
    private KafkaMetrics metrics;

    @Test
    void testConsume_ValidEvent() {
        UserEvent event = new UserEvent();
        event.setAge(25);

        ConsumerRecord<String, UserEvent> record = new ConsumerRecord<>(
                "test-topic", 0, 0L, "key", event);

        consumer.consume(event, record);

        verify(userEventService).saveEvent(any(UserEvent.class));
        verify(metrics).increment();
    }
}
