package com.example.account_service.dto;

import com.example.account_service.model.AccountType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Data
public class AccountRequestDTO {
    private String accountNumber;
    private String name; // Added the missing 'name' field
    private BigDecimal balance;
    private AccountType accountType;
    private Long userId;
}