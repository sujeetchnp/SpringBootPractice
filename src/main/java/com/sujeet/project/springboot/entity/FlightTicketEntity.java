package com.sujeet.project.springboot.entity;

import com.sujeet.project.springboot.model.SeatType;

import javax.persistence.*;

@Entity
@Table(name = "flight_tickets")
public class FlightTicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "t_id")
    private Integer tId;
    @Column(name = "t_seatNo")
    private String seatNo;

    @Column(name = "t_price")
    private Double price;

    @Column(name = "t_seatType")
    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "t_flightId")
    private FlightEntity flight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "t_uId")
    private FlightUser flightUser;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public FlightEntity getFlight() {
        return flight;
    }

    public void setFlight(FlightEntity flight) {
        this.flight = flight;
    }

    public FlightUser getFlightUser() {
        return flightUser;
    }

    public void setFlightUser(FlightUser flightUser) {
        this.flightUser = flightUser;
    }

    @Override
    public String toString() {
        return "FlightTicket{" +
                "tId=" + tId +
                ", seatNo='" + seatNo + '\'' +
                ", price=" + price +
                ", seatType=" + seatType +
//                ", Flight{\" flight=" + flight +
//                ", FlightUser{\"flightUser=" + flightUser +
                '}';
    }
}

