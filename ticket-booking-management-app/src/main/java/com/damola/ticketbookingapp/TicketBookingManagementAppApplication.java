package com.damola.ticketbookingapp;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.damola.ticketbookingapp.entities.Ticket;
import com.damola.ticketbookingapp.service.TicketBookingService;

@SpringBootApplication
public class TicketBookingManagementAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(TicketBookingManagementAppApplication.class, args);
		
		TicketBookingService ticketBookingService = applicationContext.getBean("ticketBookingService", TicketBookingService.class);
		
		Ticket ticket = new Ticket();
		ticket.setBookingDate(new Date());
		ticket.setPassengerName("Jmap");
		ticket.setSourceStation("ths");
		ticket.setDestStation("VI");
		ticket.setEmail("jmap@gmail.com");
		
		ticketBookingService.createTicket(ticket);
		
	}
}
