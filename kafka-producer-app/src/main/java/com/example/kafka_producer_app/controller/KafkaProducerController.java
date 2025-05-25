package com.example.kafka_producer_app.controller;

import com.example.kafka_producer_app.dto.UserDTO;
import com.example.kafka_producer_app.entity.UserEvent;
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
    public ResponseEntity<String> produce(@Valid @RequestBody UserDTO userDTO) {
        UserEvent userEvent = new UserEvent(userDTO.getName(), userDTO.getAge(), userDTO.getEmail(),userDTO.getCountry());
        kafkaProducerService.sendMessage(userEvent);
        return ResponseEntity.ok("UserEvent sent to Kafka successfully! 🚀");
    }
}

