package com.example.notification_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationEventConsumer {

    @KafkaListener(topics = "loan-events", groupId = "notification-group")
    public void consumeLoanEvent(String message) {
        System.out.println("Consumed loan event in notification-service: " + message);
        // Send notification based on the event
    }

    @KafkaListener(topics = "account-events", groupId = "notification-group")
    public void consumeAccountEvent(String message) {
        System.out.println("Consumed account event in notification-service: " + message);
        // Send notification based on the event
    }
}