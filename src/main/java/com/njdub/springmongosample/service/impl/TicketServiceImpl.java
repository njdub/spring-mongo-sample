package com.njdub.springmongosample.service.impl;

import com.njdub.springmongosample.controller.exception.EntityNotFoundException;
import com.njdub.springmongosample.domain.Ticket;
import com.njdub.springmongosample.domain.TicketStatus;
import com.njdub.springmongosample.model.NewTicketModel;
import com.njdub.springmongosample.repository.TicketRepository;
import com.njdub.springmongosample.service.ManagerService;
import com.njdub.springmongosample.service.TicketService;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.time.Instant;
import java.util.List;

@Component
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    private final ManagerService managerService;

    public TicketServiceImpl(TicketRepository ticketRepository, ManagerService managerService) {
        this.ticketRepository = ticketRepository;
        this.managerService = managerService;
    }

    @Override
    public Ticket saveNew(NewTicketModel ticketModel) {
        Ticket ticket = new Ticket();
        ticket.setTitle(ticketModel.getTitle());
        ticket.setDescription(ticketModel.getDescription());
        ticket.setCreated(Instant.now());
        ticket.setStatus(TicketStatus.PENDING);
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket assignToManager(BigInteger ticketId, BigInteger managerId) {
        managerService.get(managerId); // check that manager exist
        Ticket ticket = get(ticketId);
        ticket.setStatus(TicketStatus.IN_PROGRESS);
        ticket.setManagerId(managerId);
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket get(BigInteger id) {
        return ticketRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Ticket not found"));
    }
}
