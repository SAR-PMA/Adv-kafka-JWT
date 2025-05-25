package com.example.kafka_producer_app.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    // Getters and setters
    @NotBlank(message = "Name is required")
    private String name;
    @Min(value = 18, message = "Minimum age is 18")
    @Max(value = 60, message = "Maximum age is 60")
    private Integer  age;
    private String email;
    private String country;

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

