package com.njdub.springmongosample.controller;

import com.njdub.springmongosample.controller.exception.ApiException;
import com.njdub.springmongosample.domain.Ticket;
import com.njdub.springmongosample.model.NewTicketModel;
import com.njdub.springmongosample.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
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

    @GetMapping("/api/ticket/{id}")
    public ResponseEntity<Ticket> getTicket(@PathVariable BigInteger id) {
        return ResponseEntity.ok(ticketService.get(id));
    }

    @PostMapping("/api/ticket")
    public ResponseEntity<Ticket> postNewTicket(@RequestBody @Valid NewTicketModel ticketModel) {
        Ticket ticket = ticketService.saveNew(ticketModel);
        return ResponseEntity.ok(ticket);
    }

    @ExceptionHandler
    public ResponseEntity handleApiError(ApiException e) {
        return ResponseEntity.status(e.getStatus()).body(e.getMessage());
    }

}
