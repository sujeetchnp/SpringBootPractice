package com.sujeet.project.springboot.controllers;

import com.sujeet.project.springboot.model.FlightTicket;
import com.sujeet.project.springboot.service.FlightTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
