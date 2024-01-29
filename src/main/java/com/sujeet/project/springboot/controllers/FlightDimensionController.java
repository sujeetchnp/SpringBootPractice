package com.sujeet.project.springboot.controllers;

import com.sujeet.project.springboot.service.FlightDimensionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dimension")
public class FlightDimensionController {
    private FlightDimensionService flightDimensionService;

}
