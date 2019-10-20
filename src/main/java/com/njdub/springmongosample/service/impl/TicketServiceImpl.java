package com.njdub.springmongosample.service.impl;

import com.njdub.springmongosample.domain.Ticket;
import com.njdub.springmongosample.model.NewTicketModel;
import com.njdub.springmongosample.repository.TicketRepository;
import com.njdub.springmongosample.service.TicketService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket saveNew(NewTicketModel ticketModel) {
        Ticket ticket = new Ticket();
        ticket.setTitle(ticketModel.getTitle());
        ticket.setDescription(ticketModel.getDescription());
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }
}
