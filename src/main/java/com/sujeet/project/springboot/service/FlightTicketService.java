package com.sujeet.project.springboot.service;

import com.sujeet.project.springboot.entity.FlightEntity;
import com.sujeet.project.springboot.entity.FlightTicketEntity;
import com.sujeet.project.springboot.entity.FlightUserEntity;
import com.sujeet.project.springboot.model.FlightTicket;
import com.sujeet.project.springboot.model.SeatType;
import com.sujeet.project.springboot.repository.FlightTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightTicketService {

    @Autowired
    private FlightTicketRepository flightTicketRepository;

    @Autowired
    private FlightService flightService;

    @Autowired
    private FlightUserService flightUserService;


    @PostConstruct
    public void init() {
        System.out.println("FlightTicketService Bean initialization");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("FlightTicketService Bean before destroy");
    }

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
        List<FlightTicket> flightTicketList = new ArrayList<>();
        for (FlightTicketEntity fe : flightTicketEntityList) {
            FlightTicket m = fromEntity(fe);

            FlightEntity flightEntity = fe.getFlight();
            m.setFlight(flightService.fromEntity(flightEntity));

            FlightUserEntity flightUserEntity = fe.getFlightUser();
            m.setFlightUser(flightUserService.fromEntity(flightUserEntity));

            flightTicketList.add(m);
        }
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

    private FlightTicketEntity toEntity(FlightTicket flightTicket) {
        FlightTicketEntity entity = new FlightTicketEntity();
        entity.settId(flightTicket.getTicketId());
        entity.setPrice(flightTicket.getTicketPrice());
        entity.setSeatNo(flightTicket.getSeatNum());
        entity.setSeatType(flightTicket.getTicketSeatType());

        FlightEntity flightEntity = new FlightEntity();
        flightEntity.setFlightId(flightTicket.getFlight().getfId());
        entity.setFlight(flightEntity);

        FlightUserEntity flightUserEntity = new FlightUserEntity();
        flightUserEntity.setUserId(flightTicket.getFlightUser().getuId());
        entity.setFlightUser(flightUserEntity);

        return entity;

    }

    public void insertTickets(FlightTicket flightTicket) {
        FlightTicketEntity tEntity = toEntity(flightTicket);
        FlightTicketEntity savedEntity = flightTicketRepository.save(tEntity);
        FlightTicket fTicketModel = fromEntity(savedEntity);
    }
}
