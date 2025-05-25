package com.example.kafka_consumer_app.service;

import com.example.kafka_consumer_app.entity.UserEvent;
import com.example.kafka_consumer_app.repository.UserEventRepository;
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
    @Autowired
    private UserEventRepository repository;

    //    @KafkaListener(
//            topics = "${app.kafka.topic-name}",
//            groupId = "${app.kafka.consumer.group-id}",
//            containerFactory = "kafkaListenerContainerFactory")
//    public void consume(UserDTO user) {
//        logger.info("🛸 Received JSON UserDTO: {}", user);
//
//    }
    @KafkaListener(
            topics = "${app.kafka.topic-name}",
            groupId = "${app.kafka.consumer.group-id}"
    )
    public void consume(UserEvent event, ConsumerRecord<String, UserEvent> record) {
        logger.info("📥 Received UserEvent: {}", event);

        // Enrich the event
        event.setCreatedAt(LocalDateTime.now());
        event.setKafkaPartition(record.partition());
        event.setKafkaOffset(record.offset());

        repository.save(event);
        logger.info("💾 Persisted enriched UserEvent to DB");
    }


}

