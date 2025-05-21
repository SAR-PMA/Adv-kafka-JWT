package com.example.kafka_producer_app.service;

import com.example.kafka_producer_app.entity.UserEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

        private final KafkaTemplate<String, UserEvent> kafkaTemplate;
        private final String topicName;
        private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);

        public KafkaProducerService(KafkaTemplate<String, UserEvent> kafkaTemplate,
                                    @Value("${app.kafka.topic-name}") String topicName) {
            this.kafkaTemplate = kafkaTemplate;
            this.topicName = topicName;
        }

        public void sendMessage(UserEvent user) {
            kafkaTemplate.send(topicName, user);
            logger.info("🎯 Sent UserDTO message='{}' to topic='{}'", user, topicName);
        }
    }
