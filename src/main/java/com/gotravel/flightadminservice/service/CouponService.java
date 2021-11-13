package com.gotravel.flightadminservice.service;

import com.gotravel.flightadminservice.entity.Coupon;
import com.gotravel.flightadminservice.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;

    public Coupon addCoupon(final Coupon coupon) {
        return couponRepository.save(coupon);
    }
}
