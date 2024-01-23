package com.sujeet.project.springboot.service;

import com.sujeet.project.springboot.repository.FlightUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FlightUserService {

    @Autowired
    private FlightUserRepository flightUserRepository;

    @Transactional
    public void updateUserOperation() {

        int rowsUpdated = flightUserRepository.updateFlightUser("NimeshB", 77399970, 27);
        System.out.println("Rows updated : " + rowsUpdated);
    }

}
