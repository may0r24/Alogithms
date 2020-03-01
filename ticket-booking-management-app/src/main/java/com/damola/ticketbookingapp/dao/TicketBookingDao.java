package com.damola.ticketbookingapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.damola.ticketbookingapp.entities.Ticket;

@Repository
public interface TicketBookingDao extends CrudRepository<Ticket, Integer>{

}
