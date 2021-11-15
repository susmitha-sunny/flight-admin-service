package com.gotravel.flightadminservice.service;

import com.gotravel.flightadminservice.exception.ValueNotFoundException;
import com.gotravel.flightadminservice.repository.AirlineRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class AirlineServiceTest {

    @Mock
    AirlineRepository airlineRepository;

    @Mock
    AirlineService airlineService;

    @Test
    void testSuccess() throws ValueNotFoundException {
        String airline = "Qatar Airways";
        Mockito.when(airlineRepository.blockAirline("airline")).thenReturn(1);

        String response = airlineService.blockAirline(airline);

        Assertions.assertFalse(response.isEmpty());
        Assertions.assertEquals("Airline Qatar Airways is blocked successfully", response);
    }
}
