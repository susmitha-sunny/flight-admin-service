package com.gotravel.flightadminservice.controller;

import com.gotravel.flightadminservice.entity.Airline;
import com.gotravel.flightadminservice.exception.ValueNotFoundException;
import com.gotravel.flightadminservice.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    @PostMapping(value = "/addairline")
    public Airline execute(@RequestBody final Airline airline) {
        return airlineService.addAirline(airline);
    }

    @PutMapping(value = "/blockairline")
    public String executeBlock(@RequestBody final Airline airline) throws ValueNotFoundException {
        return airlineService.blockAirline(airline.getAirlineName());
    }
}
