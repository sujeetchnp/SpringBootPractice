package com.sujeet.project.springboot.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "flight_users")
public class FlightUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uId")
    private Integer userId;

    @Column(name = "uName")
    private String name;

    @Column(name = "uPhone")
    private Integer phone;

    @OneToMany(mappedBy = "flightUser", fetch = FetchType.LAZY)
    private List<FlightTicketEntity> flightTickets;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "addressid")
    private UserAddressEntity userAddress;


    public List<FlightTicketEntity> getFlightTickets() {
        return flightTickets;
    }

    public void setFlightTickets(List<FlightTicketEntity> flightTickets) {
        this.flightTickets = flightTickets;
    }

    public UserAddressEntity getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddressEntity userAddress) {
        this.userAddress = userAddress;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return
                "userId=" + userId +
                        ", name='" + name + '\'' +
                        ", phone=" + phone +
                        ", " +
                        userAddress +
                        '}';
    }
}
