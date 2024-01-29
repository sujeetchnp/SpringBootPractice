package com.sujeet.project.springboot.repository;

import com.sujeet.project.springboot.entity.FlightEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepository extends JpaRepository<FlightEntity, Integer> {          // Flight - entity AND Integer - PK type

    List<FlightEntity> findAll();


    FlightEntity findByFlightName(String flightName);

    List<FlightEntity> findBySourceAndDestination(String s, String dest);

    List<FlightEntity> findBySource(String source);

    List<FlightEntity> findByDestination(String destination);

    List<FlightEntity> findByFlightNameStartingWith(String prefix);

    long countByDestination(String destination);

    List<FlightEntity> findByFlightIdGreaterThan(Integer id);

    List<FlightEntity> findAllByOrderByFlightNameAsc();

    List<FlightEntity> findDistinctBySource(String source);

    List<FlightEntity> findDistinctByDestination(String dest);

    FlightEntity findFlightEntityByFlightId(Integer id);

    boolean existsBySource(String source);

    @Query("SELECT f FROM FlightEntity f WHERE f.source = :sourceParam AND f.destination = :destParam")
    FlightEntity findFlightForSourceAndDest(@Param("sourceParam") String source, @Param("destParam") String dest);

    @Query(nativeQuery = true, value = "SELECT * FROM flight_details WHERE fid > :idParam")
    List<FlightEntity> findManyFlightsGt(@Param("idParam") Integer id);


    @Modifying
    @Query("UPDATE FlightEntity f SET f.source = :sourceParam WHERE f.flightId = :idParam")
    int updateSource(@Param("sourceParam") String newSource, @Param("idParam") Integer id);


    @Modifying
    @Query("DELETE FROM FlightEntity f WHERE f.flightId = :idParam")
    int deleteRecord(@Param("idParam") Integer id);

    @Query("SELECT f FROM FlightEntity f")
    List<FlightEntity> getAllFlights(Pageable page);

    @Query("SELECT f FROM FlightEntity f WHERE f.destination = :destinationParam")
    List<FlightEntity> getFlightByDestination(@Param("destinationParam") String Dest);

    @Query("SELECT f FROM FlightEntity f JOIN FETCH f.flightDimension d WHERE d.flightName = :flightNameParam")
    FlightEntity findDimensionByFlightName(@Param("flightNameParam") String flightName);

}
