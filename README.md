<div align="center">
  <a href="README.pt-br.md">
    <img src="https://img.shields.io/badge/lang-pt--br-green.svg" alt="Português">
  </a>
  <a href="README.md">
    <img src="https://img.shields.io/badge/lang-en-red.svg" alt="English">
  </a>
</div>

# Notification Service

## Summary
Microservice responsible for listening to architectural events and triggering asynchronous notifications.
Currently, the application acts as a Kafka consumer, listening to new user creation events (`user-events`) originating from the main identity service (Spring Secure Identity API).

Upon receiving a creation event, this service simulates the preparation and sending of a welcome email to the user, demonstrating an Event-Driven Architecture (EDA).

## Technologies Used

* **Language:** Java 25
* **Framework:** Spring Boot 4
* **Messaging:** Apache Kafka
* **Tools:** Lombok, Gradle
* **Testing:** JUnit 5

## Applied Studies

This project was developed with a focus on distributed architecture concepts:

* **Event-Driven Architecture (EDA):** Asynchronous integration ensuring decoupling between services. The identity service does not need to know how the email is sent.
* **Messaging with Kafka:** Consuming messages from topics (`user-events`) with native JSON serialization/deserialization using `Jackson`.
* **Microservices:** Single responsibility of handling notifications in a scalable and independent manner.

## Installation and Execution

### Prerequisites
* Apache Kafka running locally (can be initialized via Docker in the `spring-secure-identity-api` project).
* Java 25.

### Step 1: Dependency (Infrastructure)
This service does not have its own `docker-compose.yml` file, as it leverages the infrastructure already declared in the main microservice.
Make sure to start Kafka in the `spring-secure-identity-api` project:

```bash
# Inside the ssi project folder:
docker compose up db kafka -d
```

### Step 2: Running the Project

You can start the service using your IDE (IntelliJ/Eclipse) or run the command via Gradle:

```bash
./gradlew bootRun
```

The application will start on the default port (or the configured port) and will automatically connect to Kafka at `localhost:9092`.
When you create a user in the main service, you will see the notification being processed in this service's console.
