package com.example.kafka_consumer_app.mapper;

import com.example.kafka_consumer_app.dto.UserDTO;
import com.example.kafka_consumer_app.entity.UserEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserEventMapper {

    public UserEvent toEntity(UserDTO dto) {
        UserEvent entity = new UserEvent();
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setEmail(dto.getEmail());
        entity.setCountry(dto.getCountry());
        entity.setCreatedAt(LocalDateTime.now()); // Set here or outside
        return entity;
    }
}
