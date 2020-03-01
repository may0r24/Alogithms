package com.damola.ticketbookingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damola.ticketbookingapp.dao.TicketBookingDao;
import com.damola.ticketbookingapp.entities.Ticket;

@Service
public class TicketBookingService {
	
	@Autowired
	private TicketBookingDao ticketBookingDao;

	public void createTicket(Ticket ticket) {
		 ticketBookingDao.save(ticket);
	}

	public Ticket getTicketById(Integer ticketId) {
		return ticketBookingDao.findOne(ticketId);
	}

}
