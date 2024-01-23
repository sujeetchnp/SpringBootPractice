package com.sujeet.project.springboot.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Flight_Details")
public class FlightEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fid")
    private Integer flightId;

    @Column(name = "f_source")
    private String source;

    @Column(name = "f_destination")
    private String destination;

    private String flightName;

    @OneToMany(mappedBy = "flight", fetch = FetchType.LAZY)
    private List<FlightTicketEntity> flightTickets;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "f_name", referencedColumnName = "flightName")
    private FlightDimension flightDimension;

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<FlightTicketEntity> getFlightTickets() {
        return flightTickets;
    }

    public void setFlightTickets(List<FlightTicketEntity> flightTickets) {
        this.flightTickets = flightTickets;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public FlightDimension getFlightDimension() {
        return flightDimension;
    }

    public void setFlightDimension(FlightDimension flightDimension) {
        this.flightDimension = flightDimension;
    }

    @Override
    public String toString() {
        return
                "flightId=" + flightId +
                        ", source='" + source + '\'' +
                        ", destination='" + destination + '\'' +
                        ", flightName='" + flightName + '\'' +
                        ", " +
//                        flightDimension +
                        '}';
    }
}
