package com.example.MyFin.service;

import com.example.MyFin.model.Loan;
import com.example.MyFin.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public List<Loan> getLoansByUserId(Long userId) {
        return loanRepository.findByUserId(userId);
    }

    public Loan applyForLoan(Loan loan) {
        return loanRepository.save(loan);
    }
}
