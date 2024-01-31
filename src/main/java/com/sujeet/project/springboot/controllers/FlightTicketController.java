package com.sujeet.project.springboot.controllers;

import com.sujeet.project.springboot.model.FlightTicket;
import com.sujeet.project.springboot.service.FlightTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/flight-tickets")
public class FlightTicketController {

    @Autowired
    private FlightTicketService flightTicketService;


    @GetMapping("/all-tickets")
    public List<FlightTicket> ticketList() {
        return flightTicketService.getAllTicketList();

    }

    @PostMapping("/save")
    public String saveFlightTicket(@Valid @RequestBody FlightTicket flightTicket) {
        flightTicketService.insertTickets(flightTicket);
        return "Flight Ticket saved successfully";
    }
}
