package com.gotravel.flightadminservice.controller;

import com.gotravel.flightadminservice.entity.Coupon;
import com.gotravel.flightadminservice.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CouponController {

    @Autowired
    private CouponService couponService;

    @PostMapping(value = "/addcoupon")
    public Coupon execute(@RequestBody final Coupon coupon) {
            return couponService.addCoupon(coupon);
    }
}
