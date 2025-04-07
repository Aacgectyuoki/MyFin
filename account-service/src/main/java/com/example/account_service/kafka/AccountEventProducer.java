package com.example.account_service.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AccountEventProducer {

    private static final String TOPIC = "account-events";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void publishEvent(String message) {
        kafkaTemplate.send(TOPIC, message);
        System.out.println("Published event to topic: " + TOPIC + " | Message: " + message);
    }
}