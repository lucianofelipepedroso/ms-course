package com.luciano.felipe.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luciano.felipe.hrpayroll.entities.Payment;
import com.luciano.felipe.hrpayroll.entities.Worker;
import com.luciano.felipe.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
//	
//	@Value(value = "${hr-worker.host}")
//	private String workerHost;
	
	public Payment getPayment(long workerId, int days) {
//		Map<String,String> uriVariable = new HashMap<>();
//		uriVariable.put("id", String.valueOf(workerId));
//		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}",Worker.class,uriVariable);
		Worker worker = workerFeignClient.findById(workerId).getBody();
		
		return new Payment(worker.getName(),worker.getDailyIncome(), days);
	}

}
