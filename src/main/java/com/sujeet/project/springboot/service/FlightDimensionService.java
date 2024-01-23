package com.sujeet.project.springboot.service;

import com.sujeet.project.springboot.repository.FlightDimensionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FlightDimensionService {
    @Autowired
    private FlightDimensionRepository flightDimensionRepository;

    @Transactional
    public void updateDimensionOperation() {
        int rowsUpdated = flightDimensionRepository.updateLengthAndBreadth(5555.0, 500.0, "AirMalaysia-222");
        System.out.println("Rows Updated : " + rowsUpdated);
    }
}
