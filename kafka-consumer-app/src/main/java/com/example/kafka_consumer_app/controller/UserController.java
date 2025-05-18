package com.example.kafka_consumer_app.controller;

import com.example.kafka_consumer_app.entity.UserEvent;
import com.example.kafka_consumer_app.repository.UserEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserEventRepository repo;

    @GetMapping
    public List<UserEvent> getAll() {
        return repo.findAll();
    }
}
