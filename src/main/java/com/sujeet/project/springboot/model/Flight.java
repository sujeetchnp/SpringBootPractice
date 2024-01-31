package com.sujeet.project.springboot.model;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Flight {
    private Integer fId;

    @NotNull
    @Size(min = 3, max = 50)
    private String fSource;

    @NotNull
    private String fDestination;
    private String fName;
    private FlightDimension flightDimension;

    @AssertTrue
    private boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public FlightDimension getFlightDimension() {
        return flightDimension;
    }

    public void setFlightDimension(FlightDimension flightDimension) {
        this.flightDimension = flightDimension;
    }

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfSource() {
        return fSource;
    }

    public void setfSource(String fSource) {
        this.fSource = fSource;
    }

    public String getfDestination() {
        return fDestination;
    }

    public void setfDestination(String fDestination) {
        this.fDestination = fDestination;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "fId=" + fId +
                ", fSource='" + fSource + '\'' +
                ", fDestination='" + fDestination + '\'' +
                ", fName='" + fName + '\'' +
                '}';
    }
}
