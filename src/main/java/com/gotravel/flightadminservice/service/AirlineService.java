package com.gotravel.flightadminservice.service;

import com.gotravel.flightadminservice.connector.BookingConnector;
import com.gotravel.flightadminservice.entity.Airline;
import com.gotravel.flightadminservice.exception.ValueNotFoundException;
import com.gotravel.flightadminservice.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineService {

    @Autowired
    private BookingConnector bookingConnector;

    @Autowired
    private AirlineRepository airlineRepository;

    public Airline addAirline(final Airline airline) {
        return airlineRepository.save(airline);
    }

    public boolean blockAirline(final String airlineName) throws ValueNotFoundException {
        if (airlineRepository.blockAirline(airlineName) >= 1) {
            //return "Airline " + airlineName + " blocked successfully";
            bookingConnector.cancelreservation(airlineName);
            return true;
        }
        throw new ValueNotFoundException("Airline could not be blocked");
    }

    public boolean unblockAirline(final String airlineName) throws ValueNotFoundException {
        if (airlineRepository.unblockAirline(airlineName) >= 1) {
            //return "Airline " + airlineName + " unblocked successfully";
            return true;
        }
        throw new ValueNotFoundException("Airline could not be unblocked");
    }

    public List<Airline> getAirlines() {
        return airlineRepository.findAll();
    }
}
