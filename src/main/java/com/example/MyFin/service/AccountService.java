package com.example.MyFin.service;

import com.example.MyFin.model.Account;
import com.example.MyFin.model.User;
import com.example.MyFin.repository.AccountRepository;
import com.example.MyFin.repository.UserRepository; // ✅ Import UserRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository; // ✅ Add UserRepository

    @Autowired
    public AccountService(AccountRepository accountRepository, UserRepository userRepository) { // ✅ Inject UserRepository
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    public List<Account> getAccountsByUserId(Long userId) {
        return accountRepository.findByUserId(userId);
    }

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    public Account createAccountForUser(Long userId, Account account) {
        // ✅ Now userRepository is defined!
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        account.setUser(user);
        return accountRepository.save(account);
    }
}
