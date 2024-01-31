package com.sujeet.project.springboot.controllers;

import com.sujeet.project.springboot.exception.DataIntegrityViolationException;
import com.sujeet.project.springboot.model.Flight;
import com.sujeet.project.springboot.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

        Flight flightById = flightService.getFlightById(id);
        return flightById;

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
    public String saveFlight(@Valid @RequestBody Flight flight) {
        if (flight.getfId() != null && flightService.existsById(flight.getfId())) {
            throw new DataIntegrityViolationException("Flight with ID " + flight.getfId() + " already exists.");
        }
        flightService.insertFlights(flight);
        return "Flight saved successfully";
    }

}
