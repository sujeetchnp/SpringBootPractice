package com.sujeet.project.springboot.service;

import com.sujeet.project.springboot.entity.FlightTicketEntity;
import com.sujeet.project.springboot.model.FlightTicket;
import com.sujeet.project.springboot.model.SeatType;
import com.sujeet.project.springboot.repository.FlightTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightTicketService {

    @Autowired
    private FlightTicketRepository flightTicketRepository;

    @Transactional
    public void updateTicketOperation() {
        int rowsUpdated = flightTicketRepository.updateFlightTickets("K7", SeatType.ECONOMY, 700.0, 34);
        System.out.println("Rows Updated : " + rowsUpdated);
    }

    @Transactional
    public void deleteTicketOperation() {
        int rowsDeleted = flightTicketRepository.deleteTicketById(36);
        System.out.println("Rows Deleted : " + rowsDeleted);

    }

    public List<FlightTicket> getAllTicketList() {
        List<FlightTicketEntity> flightTicketEntityList = flightTicketRepository.getAllTickets();
        List<FlightTicket> flightTicketList = fromEntityList(flightTicketEntityList);
        return flightTicketList;
    }

    private FlightTicket fromEntity(FlightTicketEntity entity) {
        FlightTicket model = new FlightTicket();
        model.setSeatNum(entity.getSeatNo());
        model.setTicketSeatType(entity.getSeatType());
        model.setTicketPrice(entity.getPrice());
        model.setTicketId(entity.gettId());
        return model;
    }

    private List<FlightTicket> fromEntityList(List<FlightTicketEntity> entityList) {
        List<FlightTicket> flightTicketList = new ArrayList<>();

        for (FlightTicketEntity entity : entityList) {
            FlightTicket model = fromEntity(entity);
            flightTicketList.add(model);
        }
        return flightTicketList;
    }
}
