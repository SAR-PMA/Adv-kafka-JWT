package com.example.kafka_producer_app.controller;

import com.example.kafka_producer_app.dto.UserDTO;
import com.example.kafka_producer_app.service.KafkaProducerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produce")
public class KafkaProducerController {

    private final KafkaProducerService kafkaProducerService;

    public KafkaProducerController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping
    public ResponseEntity<String> produce(@Valid @RequestBody UserDTO user) {
        kafkaProducerService.sendMessage(user);
        return ResponseEntity.ok("UserDTO message sent to Kafka successfully! 🚀");
    }
}

