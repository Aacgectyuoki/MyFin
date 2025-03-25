package com.example.MyFin.service;

import com.example.MyFin.model.EMI;
import com.example.MyFin.repository.EMIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EMIService {

    private final EMIRepository emiRepository;

    public EMIService(EMIRepository emiRepository) {
        this.emiRepository = emiRepository;
    }

    public List<EMI> getEmiByLoanId(Long loanId) {
        return emiRepository.findByLoanId(loanId);
    }
}
