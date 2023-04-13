package com.matheusleite.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.matheusleite.hrpayroll.entities.Payment;
import com.matheusleite.hrpayroll.entities.Worker;
import com.matheusleite.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(long workerId, int daysWorked) {
		ResponseEntity<Worker> workerResponseEntity = workerFeignClient.findById(workerId);
		Worker worker = workerResponseEntity.getBody();
		 
		return new Payment(worker.getName(), worker.getDailyIncome(), daysWorked);
	}
}
