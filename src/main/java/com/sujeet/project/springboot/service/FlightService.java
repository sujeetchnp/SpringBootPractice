package com.sujeet.project.springboot.service;

import com.sujeet.project.springboot.entity.FlightDimensionEntity;
import com.sujeet.project.springboot.entity.FlightEntity;
import com.sujeet.project.springboot.exception.ResourceNotFoundException;
import com.sujeet.project.springboot.model.Flight;
import com.sujeet.project.springboot.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)  // new objects on every request
@Service
public class FlightService {

    private String temp;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    @Autowired
    private FlightRepository flightRepository;

    public boolean existsById(Integer id) {
        return flightRepository.existsById(id);
    }

    public List<Flight> getAllFlights() {
        List<FlightEntity> flightEntityList = flightRepository.findAll();
//        if (flightEntityList.size() > 2) {
//            throw new RuntimeException("Too many flights received");
//        }
        List<Flight> flightList = fromEntityList(flightEntityList);
        return flightList;
    }

    public Flight fromEntity(FlightEntity entity) {
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

    private FlightEntity toEntity(Flight flight) {
        FlightEntity entity = new FlightEntity();
        entity.setFlightId(flight.getfId());
        entity.setSource(flight.getfSource());
        entity.setDestination(flight.getfDestination());

        FlightDimensionEntity flightDimensionEntity = new FlightDimensionEntity();
        flightDimensionEntity.setFlightName(flight.getfName());
        flightDimensionEntity.setHeight(flight.getFlightDimension().getdHeight());
        flightDimensionEntity.setLength(flight.getFlightDimension().getdLength());
        flightDimensionEntity.setWidth(flight.getFlightDimension().getdWidth());
        entity.setFlightDimension(flightDimensionEntity);
        return entity;
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

    public List<Flight> getFlightsByDestination(String dest) {
        List<FlightEntity> entityList = flightRepository.findByDestination(dest);
        List<Flight> flightDestList = fromEntityList(entityList);
        return flightDestList;
    }

    public List<Flight> getFlightsBySrcAndDest(String source, String destination) {
        List<FlightEntity> entityList = flightRepository.findBySourceAndDestination(source, destination);
        List<Flight> flightDestList = fromEntityList(entityList);
        return flightDestList;
    }

    public Flight getFlightById(Integer id) {
//        FlightEntity fEntity = flightRepository.findFlightEntityByFlightId(id);
        FlightEntity fEntity = flightRepository.findById(id).orElse(null);
        if (fEntity == null) {
            throw new ResourceNotFoundException("Flight with this " + id + " id not found. ");
        }
        Flight entityModel = fromEntity(fEntity);
        return entityModel;
    }

    public Flight insertFlights(Flight flight) {
        FlightEntity fEntity = toEntity(flight);
        FlightEntity savedEntity = flightRepository.save(fEntity);
        Flight flightModel = fromEntity(savedEntity);
        return flightModel;
    }

}
