package com.gotravel.flightadminservice.controller;

import com.gotravel.flightadminservice.entity.Flight;
import com.gotravel.flightadminservice.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping(value = "/addflight")
    public Flight execute(@RequestBody final Flight flight) {
            return flightService.addFlight(flight);
    }

    @CrossOrigin
    @GetMapping(value = "/flight")
    public List<Flight> execute() {
        System.out.println("inside flight admin");
        return flightService.getFlights();
    }
}
