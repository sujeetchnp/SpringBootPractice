package com.sujeet.project.springboot.repository;

import com.sujeet.project.springboot.entity.FlightUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightUserRepository extends JpaRepository<FlightUser, Integer> {


//    int updateFlightUser(@Param() FlightUser flightUser);   // how to do this in case of passing whole object

    @Modifying
    @Query("UPDATE FlightUser SET name = :name_param, phone = :phone_param WHERE userId = :userId_param")
    int updateFlightUser(@Param("name_param") String newUserName, @Param("phone_param") Integer newUserPhone, @Param("userId_param") Integer uId);

    List<FlightUser> findAll();

    @Query("SELECT u FROM FlightUser u JOIN FETCH u.userAddress WHERE u.userId = :fUserIdParam")
    FlightUser findAddressByUserId(@Param("fUserIdParam") Integer uId);

    @Query("SELECT u FROM FlightUser u JOIN FETCH u.userAddress a WHERE a.city = :cityParam")
    List<FlightUser> findUserByCity(@Param("cityParam") String city);
}
