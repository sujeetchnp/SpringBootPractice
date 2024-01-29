package com.sujeet.project.springboot.repository;

import com.sujeet.project.springboot.entity.FlightDimensionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightDimensionRepository extends JpaRepository<FlightDimensionEntity, String> {

    FlightDimensionEntity findByFlightName(String flightName);

    List<FlightDimensionEntity> findAll();

    @Query("SELECT d FROM FlightDimensionEntity d WHERE d.height > :heightParam")
    List<FlightDimensionEntity> getAllFlightNamesGT(@Param("heightParam") Double height);

    @Modifying
    @Query("UPDATE FlightDimensionEntity d SET d.length = :lengthParam, d.width = :widthParam WHERE d.flightName = :flightNameParam")
    int updateLengthAndBreadth(@Param("lengthParam") Double newLength, @Param("widthParam") Double newWidth, @Param("flightNameParam") String flightName);

}
