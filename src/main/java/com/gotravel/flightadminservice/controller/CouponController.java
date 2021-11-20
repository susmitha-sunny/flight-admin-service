package com.gotravel.flightadminservice.controller;

import com.gotravel.flightadminservice.entity.Coupon;
import com.gotravel.flightadminservice.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CouponController {

    @Autowired
    private CouponService couponService;

    @Autowired
    private KafkaTemplate<String, Coupon> kafkaTemplate;

    private static final String TOPIC = "flight_discountcoupon";

    @PostMapping(value = "/addcoupon")
    public Coupon execute(@RequestBody final Coupon coupon) {
            return couponService.addCoupon(coupon);
    }

    @PostMapping(value = "/addcoupontoqueue")
    public String executeQueue(@RequestBody final Coupon coupon) {
        kafkaTemplate.send(TOPIC, coupon);
        return "Coupon added to queue successfully";
    }
}
