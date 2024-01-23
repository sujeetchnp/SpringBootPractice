package com.sujeet.project.springboot.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_address")
public class UserAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "a_id")
    private Integer id;
    private String city;
    private String country;
    private String zipCode;
    @OneToOne(mappedBy = "userAddress", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private FlightUser flightUser;

    public FlightUser getFlightUser() {
        return flightUser;
    }

    public void setFlightUser(FlightUser flightUser) {
        this.flightUser = flightUser;
    }

    public String getCity() {
        return city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return
                "aId=" + id +
                        ", city='" + city + '\'' +
                        ", country='" + country + '\'' +
                        ", zipCode='" + zipCode + '\'' +
                        '}';
    }
}
