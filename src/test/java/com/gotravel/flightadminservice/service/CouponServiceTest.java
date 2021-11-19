package com.gotravel.flightadminservice.service;

import com.gotravel.flightadminservice.connector.BookingConnector;
import com.gotravel.flightadminservice.controller.CouponController;
import com.gotravel.flightadminservice.entity.Coupon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class CouponServiceTest {

    private static Coupon coupon;

    @Mock
    BookingConnector bookingConnector;

    @InjectMocks
    CouponService couponService;

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
        Mockito.when(bookingConnector.addCoupon(ArgumentMatchers.any())).thenReturn(coupon);

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
        Mockito.when(bookingConnector.addCoupon(ArgumentMatchers.any())).thenReturn(null);

        //act
        Coupon coupon = couponService.addCoupon(request);

        //assert
        assertNull(coupon);
    }
}
