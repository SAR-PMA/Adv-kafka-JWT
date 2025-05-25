package com.example.kafka_consumer_app;

import com.example.kafka_consumer_app.service.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JwtServiceTest {

    @Autowired
    private JwtService jwtService;

    private final String username = "testUser";

    @Test
    void testGenerateAndValidateToken() {
        String token = jwtService.generateToken(username);

        assertNotNull(token);
        assertTrue(jwtService.validateToken(token));
        assertEquals(username, jwtService.extractUsername(token));
    }
}
