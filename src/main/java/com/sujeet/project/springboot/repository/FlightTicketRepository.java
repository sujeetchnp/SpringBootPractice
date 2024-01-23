package com.sujeet.project.springboot.repository;

import com.sujeet.project.springboot.entity.FlightTicketEntity;
import com.sujeet.project.springboot.model.SeatType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightTicketRepository extends JpaRepository<FlightTicketEntity, Integer> {

    @Query("SELECT t FROM FlightTicketEntity t JOIN FETCH t.flight f JOIN FETCH t.flightUser u WHERE t.tId = :tIdParam")
    FlightTicketEntity findFlightDetailsByTicketId(@Param("tIdParam") Integer id);


    @Query("SELECT t FROM FlightTicketEntity t JOIN FETCH t.flightUser u WHERE u.phone = :uPhone_param")
    List<FlightTicketEntity> findTicketByPhoneNumber(@Param("uPhone_param") Integer phone);

    @Modifying
    @Query("UPDATE FlightTicketEntity SET seatNo = :seatNoParam, seatType = :seatTypeParam, price = :priceParam WHERE tId = :tIdParam")
    int updateFlightTickets(@Param("seatNoParam") String newSeatNum, @Param("seatTypeParam") SeatType newSeatType, @Param("priceParam") Double newPrice, @Param("tIdParam") Integer tId);

    @Modifying
    @Query("DELETE FROM FlightTicketEntity WHERE tId = :tIdParam")
    int deleteTicketById(@Param("tIdParam") Integer tId);

    List<FlightTicketEntity> findFlightTicketBySeatType(SeatType seatType);

    @Query("SELECT t FROM FlightTicketEntity t")
    List<FlightTicketEntity> getAllFlightTickets(Pageable pageable);

    @Query("SELECT t FROM FlightTicketEntity t")
    List<FlightTicketEntity> getAllTickets();
}
