package com.sujeet.project.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flight_dimensions")
public class FlightDimensionEntity {

    @Id
    private String flightName;
    private Double length;
    private Double width;
    private Double height;


    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return
                "flightName='" + flightName + '\'' +
                        ", length=" + length +
                        ", width=" + width +
                        ", height=" + height +
                        '}';
    }
}
