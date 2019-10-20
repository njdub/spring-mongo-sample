package com.njdub.springmongosample.repository;

import com.njdub.springmongosample.domain.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface TicketRepository extends MongoRepository<Ticket, BigInteger> {

}
