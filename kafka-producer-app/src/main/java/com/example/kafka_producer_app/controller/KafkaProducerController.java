package com.example.kafka_producer_app.controller;

import com.example.kafka_producer_app.service.KafkaProducerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produce")
public class KafkaProducerController {

    private final KafkaProducerService kafkaProducerService;

    public KafkaProducerController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping
    public String produce(@RequestBody String message) {
        kafkaProducerService.sendMessage(message);
        return "Message sent!";
    }
}

