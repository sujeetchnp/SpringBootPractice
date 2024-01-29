package com.sujeet.project.springboot;


import com.sujeet.project.springboot.entity.*;
import com.sujeet.project.springboot.model.SeatType;
import com.sujeet.project.springboot.repository.*;
import com.sujeet.project.springboot.service.FlightDimensionService;
import com.sujeet.project.springboot.service.FlightService;
import com.sujeet.project.springboot.service.FlightTicketService;
import com.sujeet.project.springboot.service.FlightUserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@SpringBootApplication
public class MainRunner {
    private static FlightRepository flightRepository;
    private static UserAddressRepository userAddressRepository;
    private static FlightTicketRepository flightTicketRepository;
    private static FlightUserRepository flightUserRepository;
    private static FlightDimensionRepository flightDimensionRepository;

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(MainRunner.class);

        FlightRepository flightRepository = context.getBean(FlightRepository.class);
        UserAddressRepository userAddressRepository = context.getBean(UserAddressRepository.class);
        FlightTicketRepository flightTicketRepository = context.getBean(FlightTicketRepository.class);
        FlightUserRepository flightUserRepository = context.getBean(FlightUserRepository.class);
        FlightDimensionRepository flightDimensionRepository = context.getBean(FlightDimensionRepository.class);

//        MyAppService myAppService = context.getBean(MyAppService.class);
//        myAppService.printAppName();

        FlightService flightService = context.getBean(FlightService.class);
        flightService.setTemp("abc");
        System.out.println(flightService.getTemp());
        FlightService flightService1 = context.getBean(FlightService.class);
        System.out.println(flightService1.getTemp());
//        System.out.println(flightService.getAllFlights());
//        flightService.multipleOperation();

        FlightTicketService flightTicketService = context.getBean(FlightTicketService.class);
//        flightTicketService.updateTicketOperation();
//        flightTicketService.deleteTicketOperation();

        FlightDimensionService flightDimensionService = context.getBean(FlightDimensionService.class);
//        flightDimensionService.updateDimensionOperation();

        FlightUserService flightUserService = context.getBean(FlightUserService.class);
//        flightUserService.updateUserOperation();


//        flight();

//        userAddress(userAddressRepository);

//        flightUser(flightUserRepository);

//        flightTicket(flightTicketRepository);

//        flightDimension(flightRepository, flightDimensionRepository);


    }

    public static void flight(FlightRepository flightRepository) {

//        FlightEntity flight = new FlightEntity();
//        flight.setFlightName("RoyalNepal");
//        flight.setSource("KTM");
//        flight.setDestination("DOHA");
//
//        flightRepository.save(flight);

//        List<Flight> flightList = flightRepository.findAll();
//        System.out.println(flightList);

//        Flight flightDimen = flightRepository.findDimensionByFlightName("AirDubai-555");
//        System.out.println(flightDimen);


//        List<Flight> flightsByDestination = flightRepository.getFlightByDestination("India");
//        System.out.println(flightsByDestination);

//        PageRequest pageRequest = PageRequest.of(1, 2);
//        List<Flight> flightList = flightRepository.getAllFlights(pageRequest);
//        System.out.println(flightList);

//        flightRepository.deleteById(2);
//
//        Optional<Flight> opt = flightRepository.findById(552);
//        Flight flight1 = opt.get();
//        System.out.println(flight1);
//        flight1.setDestination("India");
//        flightRepository.save(flight1);
//
//        Flight flight2 = flightRepository.findByFlightName("AirCanada-430");
//
//        Flight flight3 = flightRepository.findBySourceAndDestination("USA", "India");
//        System.out.println(flight3);
//
//        List<Flight> flightsSource = flightRepository.findBySource("USA");
//        System.out.println(flightsSource);
//
//
//        List<Flight> flightsDest = flightRepository.findByDestination("India");
//        System.out.println(flightsDest);
//
//        List<Flight> flightsPref = flightRepository.findByFlightNameStartingWith("Air");
//        System.out.println(flightsPref);
//
//        long countDest = flightRepository.countByDestination("India");
//        System.out.println(countDest);
//
//        List<Flight> flightGt = flightRepository.findByFlightIdGreaterThan(552);
//        System.out.println(flightGt);
//
//        List<Flight> flightAsc = flightRepository.findAllByOrderByFlightNameAsc();
//        System.out.println(flightAsc);
//
//        List<Flight> flightDistinctSource = flightRepository.findDistinctBySource("USA");
//        System.out.println(flightDistinctSource);
//
//        List<Flight> flightDistinctDest = flightRepository.findDistinctByDestination("India");
//        System.out.println(flightDistinctDest);
//
//        boolean sourceExists = flightRepository.existsBySource("Canada");
//        System.out.println(sourceExists);
//
//        Flight flight4 = flightRepository.findFlightForSourceAndDest("USA", "India");
//        System.out.println(flight4);
//
//        List<Flight> flight5 = flightRepository.findManyFlightsGt(552);
//        System.out.println(flight5);
//
//        flightRepository.updateSource("Australia", 3);
//
//        flightRepository.deleteRecord(3);
    }


    public static void flightTicket(FlightTicketRepository flightTicketRepository) {
        FlightTicketEntity flightTicket1 = new FlightTicketEntity();
        flightTicket1.setSeatNo("A2");
        flightTicket1.setPrice(3300.0);
        flightTicket1.setSeatType(SeatType.BUSINESS);

        FlightEntity flight1 = new FlightEntity();
        flight1.setFlightId(44);
        flightTicket1.setFlight(flight1);

        FlightUserEntity flightUser1 = new FlightUserEntity();
        flightUser1.setUserId(42);
        flightTicket1.setFlightUser(flightUser1);

//        flightTicketRepository.save(flightTicket1);

//        FlightTicket flightDetailsByTid = flightTicketRepository.findFlightDetailsByTicketId(34);
//        System.out.println(flightDetailsByTid);

//        List<FlightTicket> resultList = flightTicketRepository.findTicketByPhoneNumber(985107844);
//        System.out.println(resultList);

//        List<FlightTicket> flightList = flightTicketRepository.findFlightTicketBySeatType(SeatType.BUSINESS);
//        System.out.println(flightList);

        PageRequest pageRequest = PageRequest.of(0, 2);
        List<FlightTicketEntity> flightTicketList = flightTicketRepository.getAllFlightTickets(pageRequest);
        System.out.println(flightTicketList);

    }


    public static void userAddress(UserAddressRepository userAddressRepository) {
        UserAddressEntity userAddress = new UserAddressEntity();
        userAddress.setCity("Boston");
        userAddress.setCountry("USA");
        userAddress.setZipCode("03108");

//        userAddressRepository.save(userAddress);

//        List<UserAddress> userAddressList = userAddressRepository.findAll();
//        System.out.println(userAddressList);

//        List<UserAddress> userAddressByCityList = userAddressRepository.findUserAddressByCity("Dover");
//        System.out.println(userAddressByCityList);

    }

    public static void flightUser(FlightUserRepository flightUserRepository) {
        FlightUserEntity flightUser1 = new FlightUserEntity();
        flightUser1.setName("Annie");
        flightUser1.setPhone(77354678);

        UserAddressEntity userAddress1 = new UserAddressEntity();
        userAddress1.setId(39);
        flightUser1.setUserAddress(userAddress1);

//        flightUserRepository.save(flightUser1);

//        List<FlightUser> flightUserList = flightUserRepository.findAll();
//        System.out.println(flightUserList);

//        FlightUser flightUser = flightUserRepository.findAddressByUserId(35);
//        System.out.println(flightUser);

//        List<FlightUser> flightUserByCityList = flightUserRepository.findUserByCity("Boston");
//        System.out.println(flightUserByCityList);


    }


    public static void flightDimension(FlightRepository flightRepository, FlightDimensionRepository flightDimensionRepository) {

        FlightDimensionEntity flightDimension = new FlightDimensionEntity();
        flightDimension.setFlightName("UnitedAirlines-999");
        flightDimension.setHeight(1000.0);
        flightDimension.setLength(900.0);
        flightDimension.setWidth(800.0);

        FlightEntity flight = new FlightEntity();
        flight.setFlightDimension(flightDimension);
        flight.setSource("SanFrancisco");
        flight.setDestination("Boston");
//        flight.setFlightName("UnitedAirlines-999");
//        flightRepository.save(flight);


//        FlightDimension dimensionByFlightName = flightDimensionRepository.findByFlightName("AirMalaysia-222");
//        System.out.println(dimensionByFlightName);

//        List<FlightDimension> flightDimensionList = flightDimensionRepository.findAll();
//        System.out.println(flightDimensionList);

//        List<FlightDimension> flightByHeightGTList = flightDimensionRepository.getAllFlightNamesGT(999.0);
//        System.out.println(flightByHeightGTList);

    }

}