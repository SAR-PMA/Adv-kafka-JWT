package com.example.kafka_consumer_app.entity;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_event")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEvent {
    // Getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Min(value = 18, message = "Minimum age is 18")
    @Max(value = 60, message = "Maximum age is 60")
    private Integer age;

    private String email;

    private String country;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "kafka_partition")
    private Integer kafkaPartition;

    @Column(name = "kafka_offset")
    private Long kafkaOffset;
}