package com.sujeet.project.springboot.service;

import com.sujeet.project.springboot.entity.FlightEntity;
import com.sujeet.project.springboot.model.Flight;
import com.sujeet.project.springboot.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        List<FlightEntity> flightEntityList = flightRepository.findAll();
        List<Flight> flightList = fromEntityList(flightEntityList);
        return flightList;
    }

    private Flight fromEntity(FlightEntity entity) {
        Flight model = new Flight();
        model.setfId(entity.getFlightId());
        model.setfName(entity.getFlightName());
        model.setfSource(entity.getSource());
        model.setfDestination(entity.getDestination());
        return model;
    }

    private List<Flight> fromEntityList(List<FlightEntity> entityList) {
        List<Flight> flightList = new ArrayList<>();

        for (FlightEntity entity : entityList) {
            Flight model = fromEntity(entity);
            flightList.add(model);
        }
        return flightList;
    }

    @Transactional
    public void updateOperation() {

        int rowsUpdated = flightRepository.updateSource("China", 602);
        System.out.println("Rows updated : " + rowsUpdated);
    }

    @Transactional
    public void deleteOperation() {
        int rowsDeleted = flightRepository.deleteRecord(4);
        System.out.println("Rows Deleted : " + rowsDeleted);
    }

    public List<Flight> getFlightsByDestination() {
        List<FlightEntity> entityList = flightRepository.findByDestination("Japan");
        List<Flight> flightDestList = fromEntityList(entityList);
        return flightDestList;
    }


}
