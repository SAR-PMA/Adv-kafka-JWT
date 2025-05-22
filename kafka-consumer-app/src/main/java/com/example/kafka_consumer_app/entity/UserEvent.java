package com.example.kafka_consumer_app.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEvent {
    // Getters and setters
    @NotBlank(message = "Name is required")
    private String name;
    @Min(value = 18, message = "Minimum age is 18")
    @Max(value = 60, message = "Maximum age is 60")
    private Integer  age;
    @Column
    private String email;
    @Column
    private String country;

    @java.lang.Override
    public java.lang.String toString() {
        return "UserEvent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}


