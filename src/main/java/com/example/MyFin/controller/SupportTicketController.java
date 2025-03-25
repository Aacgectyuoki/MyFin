package com.example.MyFin.controller;

import com.example.MyFin.model.SupportTicket;
import com.example.MyFin.service.SupportTicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/support")
public class SupportTicketController {

    private final SupportTicketService supportTicketService;

    public SupportTicketController(SupportTicketService supportTicketService) {
        this.supportTicketService = supportTicketService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SupportTicket>> getTicketsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(supportTicketService.getTicketsByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<SupportTicket> createTicket(@RequestBody SupportTicket ticket) {
        return ResponseEntity.ok(supportTicketService.createTicket(ticket));
    }
}
