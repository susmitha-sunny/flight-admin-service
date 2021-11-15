package com.gotravel.flightadminservice.connector;

import com.gotravel.flightadminservice.entity.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BookingConnector {

    @Autowired
    private RestTemplate restTemplate;

    public Coupon addCoupon(final Coupon coupon) {

        String url = "http://FLIGHT-BOOKING-SERVICE/createcoupon";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Coupon> request = new HttpEntity<Coupon>(coupon, headers);

        ResponseEntity<Coupon> response = restTemplate.postForEntity(url, request, Coupon.class);

        return response.getBody();
    }
}
