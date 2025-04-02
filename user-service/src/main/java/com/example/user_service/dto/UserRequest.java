package com.example.user_service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UserRequest {
    private String email;
    private String name;
    private String password;

    public UserRequest() {
    }

    public UserRequest(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

}
