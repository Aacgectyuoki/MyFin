package com.example.account_service.service;

import com.example.account_service.dto.AccountRequestDTO;
import com.example.account_service.kafka.AccountEventProducer;
import com.example.account_service.model.Account;
import com.example.account_service.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private final AccountRepository accountRepository;

    @Autowired
    private AccountEventProducer accountEventProducer;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccountsByUserId(Long userId) {
        return accountRepository.findByUserId(userId);
    }

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    public Account createAccount(AccountRequestDTO accountRequestDTO) {
        // Create and save the account
        Account account = new Account();
        account.setName(accountRequestDTO.getName());
        account.setBalance(accountRequestDTO.getBalance());
        account.setAccountType(accountRequestDTO.getAccountType()); // Updated this line
        accountRepository.save(account);

        // Publish an event to Kafka
        String eventMessage = "Account created: " + account.getName();
        accountEventProducer.publishEvent(eventMessage);

        return account;
    }
}