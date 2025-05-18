package com.example.kafka_consumer_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.kafka_consumer_app.repository")
@EntityScan(basePackages = "com.example.kafka_consumer_app.entity")
public class KafkaConsumerAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerAppApplication.class, args);
    }

}
