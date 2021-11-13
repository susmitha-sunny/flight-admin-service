package com.gotravel.flightadminservice.model;

import com.gotravel.flightadminservice.entity.Coupon;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CouponResponse {
    private Coupon coupon;
    private BigDecimal totalFare;
    private BigDecimal discountedTotalFare;
}
