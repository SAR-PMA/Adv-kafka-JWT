package com.example.kafka_consumer_app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(
            topics = "${app.kafka.topic-name}",
            groupId = "${app.kafka.consumer.group-id}")
    public void consume(String message) {
        try {
            logger.info("🛸 Received message: {}", message);
            logger.info("🛸 Received message: {}", message);
        } catch (Exception ex) {
            logger.error("🚨 Error processing message: {}", message, ex);
        }
    }
}

