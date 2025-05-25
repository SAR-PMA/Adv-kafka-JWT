package com.example.kafka_consumer_app.controller;

import com.example.kafka_consumer_app.dto.UserDTO;
import com.example.kafka_consumer_app.entity.UserEvent;
import com.example.kafka_consumer_app.repository.UserEventRepository;
import com.example.kafka_consumer_app.service.UserEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

//    @Autowired
//    private UserEventRepository repo;
//
//    @GetMapping
//    public List<UserEvent> getAll() {
//        return repo.findAll();
//    }
//}
@Autowired
private UserEventService userEventService;

//    @GetMapping
//    public List<UserDTO> getAllUserEvents() {
//        return userEventService.getAllEvents();
//    }
    @GetMapping("/users")
    public ResponseEntity<Page<UserDTO>> getAllUserEvents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).descending());
        Page<UserDTO> userDTOPage = userEventService.getAllEvents(pageable);
        return ResponseEntity.ok(userDTOPage);
    }
}