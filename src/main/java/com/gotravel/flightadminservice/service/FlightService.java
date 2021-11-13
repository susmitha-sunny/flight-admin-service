package com.gotravel.flightadminservice.service;

import com.gotravel.flightadminservice.entity.Flight;
import com.gotravel.flightadminservice.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public Flight addFlight(final Flight flight) {
        return flightRepository.save(flight);
    }
}
