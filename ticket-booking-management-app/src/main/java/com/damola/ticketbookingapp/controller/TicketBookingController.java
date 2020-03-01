package com.damola.ticketbookingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.damola.ticketbookingapp.entities.Ticket;
import com.damola.ticketbookingapp.service.TicketBookingService;

@RestController
public class TicketBookingController {

	@Autowired
	private TicketBookingService ticketBookingService;
	
	@RequestMapping(method=RequestMethod.POST, value="/ticket")
	public void createTicket(Ticket ticket) {
		ticketBookingService.createTicket(ticket);
	}
	@RequestMapping(value="/ticket/{ticketId}")
	public Ticket getTicketById(Integer ticketId) {
		return ticketBookingService.getTicketById(ticketId);
	}
}
