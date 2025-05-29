package com.example.kafka_consumer_app.config;

import com.example.kafka_consumer_app.entity.User;
import com.example.kafka_consumer_app.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Transactional
    @PostConstruct
    public void init() {
        if (userRepository.findByUsername("testuser").isEmpty()) {
            User user = new User();
            user.setUsername("testuser");
            user.setPassword(passwordEncoder.encode("testpass")); // default password
            user.setRole("ROLE_USER");

            userRepository.save(user);
            System.out.println("🚀 Default user created: testuser / testpass");
        } else {
            System.out.println("✅ Default user already exists.");
        }
    }
}
