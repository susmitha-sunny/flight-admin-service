package com.gotravel.flightadminservice.connector;

import com.gotravel.flightadminservice.entity.Coupon;

import java.math.BigDecimal;

public class MockBookingConnector extends BookingConnector{

    @Override
    public Coupon addCoupon(final Coupon request) {
        Coupon coupon = new Coupon();
        coupon.setCouponId(1);
        coupon.setCode("DISCOUNT");
        coupon.setDiscountPercent(BigDecimal.valueOf(50));

        return coupon;
    }
}
