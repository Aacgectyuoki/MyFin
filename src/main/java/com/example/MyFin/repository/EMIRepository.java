package com.example.MyFin.repository;

import com.example.MyFin.model.EMI;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EMIRepository extends JpaRepository<EMI, Long> {
    List<EMI> findByLoanId(Long loanId);
}
