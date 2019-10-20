package com.njdub.springmongosample.controller;

import com.njdub.springmongosample.service.TicketService;
import com.njdub.springmongosample.domain.Ticket;
import com.njdub.springmongosample.model.NewTicketModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/api/ticket")
    public ResponseEntity<List<Ticket>> getTickets() {
        return ResponseEntity.ok(ticketService.getAll());
    }

    @PostMapping("/api/ticket")
    public ResponseEntity<Ticket> postNewTicket(@RequestBody @Valid NewTicketModel ticketModel) {
        Ticket ticket = ticketService.saveNew(ticketModel);
        return ResponseEntity.ok(ticket);
    }

}
