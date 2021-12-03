package com.gotravel.flightadminservice.controller;

import com.gotravel.flightadminservice.entity.Airline;
import com.gotravel.flightadminservice.exception.ValueNotFoundException;
import com.gotravel.flightadminservice.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    @PostMapping(value = "/addairline")
    public Airline execute(@RequestBody final Airline airline) {
        return airlineService.addAirline(airline);
    }

    @CrossOrigin
    @PutMapping(value = "/blockairline")
    public boolean executeBlock(@RequestBody final Airline airline) throws ValueNotFoundException {
        return airlineService.blockAirline(airline.getAirlineName());
    }

    @CrossOrigin
    @GetMapping(value = "/airline")
    public List<Airline> execute() {
        return airlineService.getAirlines();
    }

    @CrossOrigin
    @PutMapping(value = "/unblockairline")
    public boolean executeUnBlock(@RequestBody final Airline airline) throws ValueNotFoundException {
        return airlineService.unblockAirline(airline.getAirlineName());
    }
}
