package com.example.kafka_producer_app.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Min(value = 0, message = "Age must be a positive number")
    @Max(value = 120, message = "Age must be realistic")
    private int age;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Country cannot be blank")
    private String country;

    private LocalDateTime createdAt;

    private Integer kafkaPartition;
    private Long kafkaOffset;
}

