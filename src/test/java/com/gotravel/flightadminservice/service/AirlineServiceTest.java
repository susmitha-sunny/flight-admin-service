package com.gotravel.flightadminservice.service;

import com.gotravel.flightadminservice.exception.ValueNotFoundException;
import com.gotravel.flightadminservice.repository.AirlineRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class AirlineServiceTest {

    @Mock
    AirlineRepository airlineRepository;

    @InjectMocks
    AirlineService airlineService;

    @Test
    void testSuccess() throws ValueNotFoundException {
        String airline = "Qatar Airways";
        Mockito.when(airlineRepository.blockAirline(ArgumentMatchers.any())).thenReturn(1);

        String response = airlineService.blockAirline(airline);

        Assertions.assertFalse(response.isEmpty());
        Assertions.assertEquals("Airline Qatar Airways blocked successfully", response);
    }

    @Test
    void testFailure() {
        String airline = "Qatar Airways";
        Mockito.when(airlineRepository.blockAirline(ArgumentMatchers.any())).thenReturn(0);

        ValueNotFoundException thrown =  Assertions.assertThrows(ValueNotFoundException.class, () -> airlineService.blockAirline(airline));

        assertNotNull(thrown);
        assertEquals("Airline could not be blocked", thrown.getMessage());

    }
}
