package com.njdub.springmongosample.controller;

import com.njdub.springmongosample.controller.exception.ApiException;
import com.njdub.springmongosample.domain.Ticket;
import com.njdub.springmongosample.model.AssignTicketModel;
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

    @GetMapping("/api/ticket/search")
    public ResponseEntity<List<Ticket>> getTicketsBySearchString(@RequestParam String query) {
        return ResponseEntity.ok(ticketService.search(query));
    }

    @GetMapping("/api/ticket/{id}")
    public ResponseEntity<Ticket> getTicket(@PathVariable BigInteger id) {
        return ResponseEntity.ok(ticketService.get(id));
    }

    @PostMapping("/api/ticket")
    public ResponseEntity<Ticket> postNewTicket(@RequestBody @Valid NewTicketModel ticketModel) {
        return ResponseEntity.ok(ticketService.saveNew(ticketModel));
    }

    @PutMapping("/api/ticket/{id}/assign")
    public ResponseEntity<Ticket> assignManagerToTicket(@PathVariable BigInteger id,
                                                        @RequestBody @Valid AssignTicketModel assignModel) {
        return ResponseEntity.ok(ticketService.assignToManager(id, assignModel.getManagerId()));
    }

    @ExceptionHandler
    public ResponseEntity handleApiError(ApiException e) {
        return ResponseEntity.status(e.getStatus()).body(e.getMessage());
    }

}
