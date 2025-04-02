package com.example.notification_service.model;

import lombok.Data;

@Data
public class EmailRequest {
    private String to;
    private String subject;
    private String message;
}
