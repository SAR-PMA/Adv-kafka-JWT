package com.example.kafka_consumer_app;

import com.example.kafka_consumer_app.service.JwtService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;

class JwtServiceTest {

    private final String jwtSecret = "ThisIsASuperSecureJwtSecretKeyWith32Chars!";
    private final long jwtExpirationMs = 86400000;

    private JwtService jwtService;

    @BeforeEach
    void setUp() {
        jwtService = new JwtService();
        ReflectionTestUtils.setField(jwtService, "jwtSecret", jwtSecret);
        ReflectionTestUtils.setField(jwtService, "jwtExpirationMs", jwtExpirationMs);
    }

    @Test
    void testGenerateAndValidateToken() {
        String token = jwtService.generateToken("testUser");
        assertNotNull(token);
        assertTrue(jwtService.validateToken(token));
        assertEquals("testUser", jwtService.extractUsername(token));
    }
}

