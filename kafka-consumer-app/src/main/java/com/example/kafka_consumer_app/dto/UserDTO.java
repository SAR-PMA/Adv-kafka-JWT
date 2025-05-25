package com.example.kafka_consumer_app.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    // Getters and setters
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
    @Min(value = 18, message = "Minimum age is 18")
    @Max(value = 60, message = "Maximum age is 60")
    private Integer  age;
    private String email;
    private String country;
    private LocalDateTime createdAt;
    private Integer kafkaPartition;
    private Long kafkaOffset;

}

