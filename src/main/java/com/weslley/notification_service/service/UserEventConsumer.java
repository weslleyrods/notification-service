package com.weslley.notification_service.service;

import com.weslley.notification_service.dto.UserCreatedEventDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserEventConsumer {
    @KafkaListener(topics= "user-events", groupId = "notification-group")
    public void consumeUserCreatedEvent(UserCreatedEventDTO event) {
        System.out.println("Event received from Kafka. Preapring e-mail to: " + event.toString());
    }
}
