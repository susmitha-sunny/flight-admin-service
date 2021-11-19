package com.gotravel.flightadminservice.controller;

import com.gotravel.flightadminservice.entity.Coupon;
import com.gotravel.flightadminservice.service.CouponService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CouponControllerTest {

    private static Coupon coupon;

    @Mock
    CouponService couponService;

    @InjectMocks
    CouponController couponController;

    @BeforeAll
    static void setup() {
        coupon = getCoupon();
    }

    private static Coupon getCoupon() {
        Coupon coupon = new Coupon();
        coupon.setCouponId(1);
        coupon.setCode("DISCOUNT");
        coupon.setDiscountPercent(BigDecimal.valueOf(50));
        return coupon;
    }

    @Test
    void testSuccess() {
        //arrange
        Coupon request = new Coupon();
        request.setCode("DISCOUNT");
        request.setDiscountPercent(BigDecimal.valueOf(50));
        Mockito.when(couponService.addCoupon(ArgumentMatchers.any())).thenReturn(coupon);

        //act
        Coupon response = couponService.addCoupon(request);

        //assert
        assertNotNull(response);
        assertEquals(1, response.getCouponId());
        assertEquals("DISCOUNT", response.getCode());
        assertEquals(BigDecimal.valueOf(50), response.getDiscountPercent());
    }

    @Test
    void testFailure() {
        //arrange
        Coupon request = new Coupon();
        request.setCode("DISCOUNT");
        request.setDiscountPercent(BigDecimal.valueOf(50));
        Mockito.when(couponService.addCoupon(ArgumentMatchers.any())).thenReturn(null);

        //act
        Coupon coupon = couponController.execute(request);

        //assert
        assertNull(coupon);
    }
}
