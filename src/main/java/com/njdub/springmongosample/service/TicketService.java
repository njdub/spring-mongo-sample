package com.njdub.springmongosample.service;

import com.njdub.springmongosample.domain.Ticket;
import com.njdub.springmongosample.model.NewTicketModel;

import java.math.BigInteger;
import java.util.List;

public interface TicketService {
    Ticket saveNew(NewTicketModel ticketModel);

    List<Ticket> getAll();

    Ticket assignToManager(BigInteger ticketId, BigInteger managerId);

    Ticket get(BigInteger id);
}
