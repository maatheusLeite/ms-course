package com.matheusleite.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheusleite.hrpayroll.entities.Payment;
import com.matheusleite.hrpayroll.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

	@Autowired
	private PaymentService service;
	
	@GetMapping(value = "/{workerId}/daysworked/{daysWorked}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer daysWorked) {
		Payment payment = service.getPayment(workerId, daysWorked);
		return ResponseEntity.ok().body(payment);
	}
	
}
