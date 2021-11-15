package com.gotravel.flightadminservice.controller;

import com.gotravel.flightadminservice.connector.MockBookingConnector;
import com.gotravel.flightadminservice.entity.Coupon;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CouponControllerTest {

    @Mock
    private static MockBookingConnector bookingConnector;

    private static Coupon coupon;

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

        CouponController controller = new CouponController();
        Coupon request = new Coupon();
        request.setCode("DISCOUNT");
        request.setDiscountPercent(BigDecimal.valueOf(50));

        Coupon response = controller.execute(request);

        assertNotNull(response);
        assertEquals("DISCOUNT", response.getCode());
        assertEquals(BigDecimal.valueOf(50), response.getDiscountPercent());
    }
}
