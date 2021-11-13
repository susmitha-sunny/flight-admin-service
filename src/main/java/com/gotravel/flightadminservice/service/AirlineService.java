package com.gotravel.flightadminservice.service;

import com.gotravel.flightadminservice.entity.Airline;
import com.gotravel.flightadminservice.exception.ValueNotFoundException;
import com.gotravel.flightadminservice.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirlineService {

    @Autowired
    private AirlineRepository airlineRepository;

    public Airline addAirline(final Airline airline) {
        return airlineRepository.save(airline);
    }

    public String blockAirline(final String airlineName) throws ValueNotFoundException {
        if (airlineRepository.blockAirline(airlineName) >= 1) {
            return "Airline " + airlineName + " blocked successfully";
        }
        throw new ValueNotFoundException("Airline could not be blocked");
    }
}
