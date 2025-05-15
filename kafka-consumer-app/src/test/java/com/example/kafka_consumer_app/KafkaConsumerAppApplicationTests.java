package com.example.kafka_consumer_app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EnableAutoConfiguration(exclude = {KafkaAutoConfiguration.class})
class KafkaConsumerAppApplicationTests {
	@Test
	void contextLoads() {
	}
}
/* Proper Kafka Integration Test? Use @EmbeddedKafka
When you do want to test real Kafka integration:

@SpringBootTest
@EmbeddedKafka(partitions = 1, topics = { "employee-topic" }, brokerProperties = {
        "listeners=PLAINTEXT://localhost:9092",
        "port=9092"
})
class KafkaConsumerIntegrationTest {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Test
    void testKafkaSendAndReceive() {
        kafkaTemplate.send("employee-topic", "🔥 test message");
        // Add some logic to verify it landed (e.g., a mocked listener or consumer)
    }
}
For this to work, you need to include the embedded Kafka dependency:

x
<dependency>
    <groupId>org.springframework.kafka</groupId>
    <artifactId>spring-kafka-test</artifactId>
    <scope>test</scope>
</dependency>*/
