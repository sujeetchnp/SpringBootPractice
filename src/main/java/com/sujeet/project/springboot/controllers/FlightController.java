package com.sujeet.project.springboot.controllers;

import com.sujeet.project.springboot.model.Flight;
import com.sujeet.project.springboot.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/all-flights")
    public List<Flight> flightLists() {
        return flightService.getAllFlights();
    }

    @GetMapping("/dest")
    public List<Flight> getAllFlightsByDestination() {
        return flightService.getFlightsByDestination();
    }
}
