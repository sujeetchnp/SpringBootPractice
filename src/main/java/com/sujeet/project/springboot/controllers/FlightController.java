package com.sujeet.project.springboot.controllers;

import com.sujeet.project.springboot.model.Flight;
import com.sujeet.project.springboot.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/all-flights")
    public List<Flight> getFlightLists() {
        return flightService.getAllFlights();
    }

    @GetMapping("/dest")
    public List<Flight> getAllFlightsByDestination(@RequestParam("fDest") String destination) {
        return flightService.getFlightsByDestination(destination);
    }

    @GetMapping("/detail")
    public Flight getFlightById(@RequestParam("flightId") Integer id) {
        return flightService.getFlightById(id);
    }

    @GetMapping("/srcdest")
    public List<Flight> getFlightBySrcDest(@RequestParam("src") String source, @RequestParam(value = "dest", required = false) String destination) {
        return flightService.getFlightsBySrcAndDest(source, destination);
    }

    @GetMapping("/{flightId}/detail")
    public Flight getFlightByIdFromPath(@PathVariable("flightId") Integer id) {
        System.out.println("Getting this flight " + id);
        return new Flight();
    }

    @PostMapping("/save")
    public String saveFlight(@RequestBody Flight flight) {
        flightService.insertFlights(flight);
        return "Flight saved successfully";
    }

}
