package com.couponapp.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.couponapp.dto.Coupon;

@Service
public class CouponService {

	public Coupon getCoupon(String couponCode) {

		Coupon coupon=new Coupon(121, couponCode, null, LocalDateTime.now());//logic the logic to add more 5 days
		
		if (couponCode.equalsIgnoreCase("SUP10")) {
			coupon.setDiscount(10);
		} else if (couponCode.equalsIgnoreCase("SUP15")) {
			coupon.setDiscount(15);
		} else if (couponCode.equalsIgnoreCase("SUP05")) {
			coupon.setDiscount(5);
		} else {
			coupon.setDiscount(2);
		}
		return coupon;

	}
}
