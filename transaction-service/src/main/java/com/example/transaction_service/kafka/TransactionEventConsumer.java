package com.example.transaction_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransactionEventConsumer {

    @KafkaListener(topics = "account-events", groupId = "transaction-group")
    public void consumeEvent(String message) {
        System.out.println("Consumed account event in transaction-service: " + message);
        // Process the event
    }
}