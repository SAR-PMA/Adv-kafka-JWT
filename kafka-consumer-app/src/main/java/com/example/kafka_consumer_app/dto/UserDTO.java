package com.example.kafka_consumer_app.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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


    @Override
    public String toString() {
        return "UserDTO{name='" + name + "', age=" + age + "}";
    }
}

