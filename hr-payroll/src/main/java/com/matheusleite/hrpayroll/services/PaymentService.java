package com.matheusleite.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.matheusleite.hrpayroll.entities.Payment;
import com.matheusleite.hrpayroll.entities.Worker;

@Service
public class PaymentService {
	
	@Value("${hr-worker.host}")
	private String workerHost;

	@Autowired
	private RestTemplate restTemplate;
	
	public Payment getPayment(long workerId, int daysWorked) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", String.valueOf(workerId));
		
		String workerUrl = workerHost + "/workers/{id}";
		
		Worker worker = restTemplate.getForObject(workerUrl, Worker.class, uriVariables);		
		
		return new Payment(worker.getName(), worker.getDailyIncome(), daysWorked);
	}
}
