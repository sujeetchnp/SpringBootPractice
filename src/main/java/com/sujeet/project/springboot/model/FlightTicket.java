package com.sujeet.project.springboot.model;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class FlightTicket {
    private Integer ticketId;
    @NotNull
    private String seatNum;
    @DecimalMin("100.00")
    @DecimalMax("1000.00")
    private Double ticketPrice;

    @Future
    private LocalDate flightDate;
    @NotNull
    private SeatType ticketSeatType;

    private Flight flight;

    private FlightUser flightUser;

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public SeatType getTicketSeatType() {
        return ticketSeatType;
    }

    public void setTicketSeatType(SeatType ticketSeatType) {
        this.ticketSeatType = ticketSeatType;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public FlightUser getFlightUser() {
        return flightUser;
    }

    public void setFlightUser(FlightUser flightUser) {
        this.flightUser = flightUser;
    }
}
