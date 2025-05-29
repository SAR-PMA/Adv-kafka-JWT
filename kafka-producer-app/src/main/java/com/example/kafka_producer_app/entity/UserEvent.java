package com.example.kafka_producer_app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public UserEvent(String name, Integer age, String email, String country) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.country = country;
    }
}


