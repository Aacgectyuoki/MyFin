package com.example.user_service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Data
@Setter
public class UserResponse {
    private Long id;
    private String email;
    private String name;

    public UserResponse() {
    }

    public UserResponse(Long id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

}
