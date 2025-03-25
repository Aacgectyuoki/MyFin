package com.example.MyFin.controller;

import com.example.MyFin.model.EMI;
import com.example.MyFin.service.EMIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emis")
public class EMIController {

    private final EMIService emiService;

    public EMIController(EMIService emiService) {
        this.emiService = emiService;
    }

    @GetMapping("/loan/{loanId}")
    public ResponseEntity<List<EMI>> getEMIsByLoanId(@PathVariable Long loanId) {
        return ResponseEntity.ok(emiService.getEmiByLoanId(loanId));
    }
}
