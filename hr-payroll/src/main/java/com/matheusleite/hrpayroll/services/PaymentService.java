package com.matheusleite.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.matheusleite.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(long workerId, int daysWorked) {
		return new Payment("Bob", 200.0, daysWorked);
	}
}
