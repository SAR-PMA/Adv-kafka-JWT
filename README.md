# Spring Boot Kafka Producer & Consumer with Docker 🐳

This project demonstrates a simple **Kafka Producer** and **Consumer** built with **Spring Boot** and running inside Docker containers using **Docker Compose**.

---

## 🧩 Project Structure

```
.
├── docker-compose.yml
├── kafka-producer-app
│   ├── Dockerfile
│   ├── src
│   └── pom.xml
└── kafka-consumer-app
    ├── Dockerfile
    ├── src
    └── pom.xml
```

---

## 🛠️ Tech Stack

- Java 21 ☕
- Spring Boot 3.4.5
- Apache Kafka 🦄
- Docker & Docker Compose
- Bitnami Kafka and Zookeeper images

---

## 🚀 How to Run

### 1️⃣ Build the Producer and Consumer JARs

```bash
cd kafka-producer-app
mvn clean package

cd ../kafka-consumer-app
mvn clean package
```

### 2️⃣ Start all services

From the root folder (where `docker-compose.yml` is located):

```bash
docker-compose up --build
```

> This will spin up:
> - Zookeeper on port `2181`
> - Kafka broker on port `9092`
> - Spring Boot Producer on port `8081`
> - Spring Boot Consumer (no exposed port needed)

---

## 📬 Sending a Message

Hit the Producer API:

```bash
curl -X POST \
     -H "Content-Type: application/json" \
     -d "\"Hello Kafka!\"" \
     http://localhost:8081/api/produce
```

> ✅ Message gets sent to topic `test-topic`

> 📩 Consumer logs: `Received: Hello Kafka!`

---

## ⚙️ Kafka Configs

- **Topic**: `test-topic`
- **Group ID**: `my-group`
- **Kafka Bootstrap Server**: `kafka:9092` (inside Docker)

---

## 🧪 Troubleshooting

- ❌ *Not receiving messages?*
  - Make sure both Producer and Consumer apps are running and talking to `kafka:9092`.
- 🐢 *Slow startup?*
  - Give Kafka a few seconds to initialize before producing messages.

---

## 🧹 To Stop Everything

```bash
docker-compose down
```

---

## 💡 Tip

Use `docker-compose logs -f consumer` to watch incoming Kafka messages in real time.

---

## 🫶 Author

Built with sweat and caffeine by a tired but persistent backend dev.

