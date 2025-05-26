package com.example.kafka_consumer_app.entity;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
