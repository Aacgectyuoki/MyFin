package com.example.user_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserEventConsumer {

    @KafkaListener(topics = "account-events", groupId = "user-group")
    public void consumeEvent(String message) {
        System.out.println("Consumed account event in user-service: " + message);
        // Process the event
    }
}