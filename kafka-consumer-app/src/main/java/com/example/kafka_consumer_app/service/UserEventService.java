package com.example.kafka_consumer_app.service;

import com.example.kafka_consumer_app.dto.UserDTO;
import com.example.kafka_consumer_app.entity.UserEvent;
import com.example.kafka_consumer_app.repository.UserEventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserEventService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);
    @Autowired
    private UserEventRepository repository;

    public void saveEvent(UserEvent event) {
        repository.save(event);
        logger.info("💾 users in db now: " + repository.findAll());
    }

    //    public List<UserDTO> getAllEvents() {
//        return repository.findAll()
//                .stream()
//                .map(this::mapToDTO)
//                .collect(Collectors.toList());
//    }
    public Page<UserDTO> getAllEvents(Pageable pageable) {
        return repository.findAll(pageable)
                .map(this::mapToDTO);
    }

    //.map(e -> new UserDTO(e.getId(), e.getName(), e.getEmail(), ...))

    private UserDTO mapToDTO(UserEvent event) {
        UserDTO dto = new UserDTO();
        dto.setId(event.getId());
        dto.setName(event.getName());
        dto.setAge(event.getAge());
        dto.setEmail(event.getEmail());
        dto.setCountry(event.getCountry());
        dto.setCreatedAt(event.getCreatedAt());
        dto.setKafkaPartition(event.getKafkaPartition());
        dto.setKafkaOffset(event.getKafkaOffset());
        return dto;
    }
}
