package com.sujeet.project.springboot.repository;

import com.sujeet.project.springboot.entity.FlightUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightUserRepository extends JpaRepository<FlightUserEntity, Integer> {


//    int updateFlightUser(@Param() FlightUser flightUser);   // how to do this in case of passing whole object

    @Modifying
    @Query("UPDATE FlightUserEntity SET name = :name_param, phone = :phone_param WHERE userId = :userId_param")
    int updateFlightUser(@Param("name_param") String newUserName, @Param("phone_param") Integer newUserPhone, @Param("userId_param") Integer uId);

    @Query("SELECT u FROM FlightUserEntity u JOIN u.userAddress")
    List<FlightUserEntity> findAllFlightUsers();

    @Query("SELECT u FROM FlightUserEntity u JOIN FETCH u.userAddress WHERE u.userId = :fUserIdParam")
    FlightUserEntity findAddressByUserId(@Param("fUserIdParam") Integer uId);

    @Query("SELECT u FROM FlightUserEntity u JOIN FETCH u.userAddress a WHERE a.city = :cityParam")
    List<FlightUserEntity> findUserByCity(@Param("cityParam") String city);

    @Modifying
    @Query("DELETE FROM FlightUserEntity u WHERE u.userId = :idParam")
    int deleteUserByUserId(@Param("idParam") Integer id);
    
}
