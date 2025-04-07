package com.example.loan_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class LoanEventConsumer {

    @KafkaListener(topics = "account-events", groupId = "loan-group")
    public void consumeEvent(String message) {
        System.out.println("Consumed account event in loan-service: " + message);
        // Process the event
    }
}