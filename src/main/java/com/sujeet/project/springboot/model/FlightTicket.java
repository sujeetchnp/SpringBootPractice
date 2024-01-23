package com.sujeet.project.springboot.model;

public class FlightTicket {
    private Integer ticketId;
    private String seatNum;

    private Double ticketPrice;

    private SeatType ticketSeatType;

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
}
