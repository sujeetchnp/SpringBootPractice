package com.sujeet.project.springboot.repository;

import com.sujeet.project.springboot.entity.FlightDimension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightDimensionRepository extends JpaRepository<FlightDimension, String> {

    FlightDimension findByFlightName(String flightName);

    List<FlightDimension> findAll();
    
    @Query("SELECT d FROM FlightDimension d WHERE d.height > :heightParam")
    List<FlightDimension> getAllFlightNamesGT(@Param("heightParam") Double height);

    @Modifying
    @Query("UPDATE FlightDimension d SET d.length = :lengthParam, d.width = :widthParam WHERE d.flightName = :flightNameParam")
    int updateLengthAndBreadth(@Param("lengthParam") Double newLength, @Param("widthParam") Double newWidth, @Param("flightNameParam") String flightName);

}
