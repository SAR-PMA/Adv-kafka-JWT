package com.example.kafka_consumer_app.service;

import com.example.kafka_consumer_app.entity.UserEvent;
import com.example.kafka_consumer_app.metrics.KafkaMetrics;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class KafkaConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);
    // remember this is used without mapper and also without userservice
//    @Autowired
//    private UserEventRepository repository;
    @Autowired
    private UserEventService userEventService;

    @Autowired
    private KafkaMetrics metrics;

    //    @KafkaListener(
//            topics = "${app.kafka.topic-name}",
//            groupId = "${app.kafka.consumer.group-id}",
//            containerFactory = "kafkaListenerContainerFactory")
//    public void consume(UserDTO user) {
//        logger.info("Received JSON UserDTO: {}", user);
//
//    }
    @KafkaListener(
            topics = "${app.kafka.topic-name}",
            groupId = "${app.kafka.consumer.group-id}"
    )
    public void consume(UserEvent event, ConsumerRecord<String, UserEvent> record) {
        logger.info("Received UserEvent: {}", event);

        if (event.getAge() > 120) {
            throw new IllegalArgumentException("Age exceeds the allowed limit");
        }
//        repository.save(event);
        // Enrich event
        event.setCreatedAt(LocalDateTime.now());
        event.setKafkaPartition(record.partition());
        event.setKafkaOffset(record.offset());

        // Delegate persistence
        userEventService.saveEvent(event);
        logger.info("Persisted enriched UserEvent to DB");
        metrics.increment();
    }


}

