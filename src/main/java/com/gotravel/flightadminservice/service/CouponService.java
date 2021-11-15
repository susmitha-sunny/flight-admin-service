package com.gotravel.flightadminservice.service;

import com.gotravel.flightadminservice.connector.BookingConnector;
import com.gotravel.flightadminservice.entity.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponService {

    @Autowired
    private BookingConnector bookingConnector;

    public Coupon addCoupon(final Coupon coupon) {
        return bookingConnector.addCoupon(coupon);
    }
}
