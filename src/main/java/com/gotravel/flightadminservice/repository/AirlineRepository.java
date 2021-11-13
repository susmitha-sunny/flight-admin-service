package com.gotravel.flightadminservice.repository;

import com.gotravel.flightadminservice.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Integer> {


    @Modifying
    @Transactional
    @Query(value = "UPDATE airline a SET a.airline_status = 'INACTIVE' WHERE a.airline_name = ?1", nativeQuery = true)
    int blockAirline(String airlineName);
}
