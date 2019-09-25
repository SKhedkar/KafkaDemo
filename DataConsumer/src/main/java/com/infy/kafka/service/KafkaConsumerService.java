package com.infy.kafka.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infy.entity.Account;
import com.infy.entity.Patient;

@Service
@KafkaListener(topics = "publisher", groupId = "group_json")
public class KafkaConsumerService {
	
	static final Logger logger = Logger.getLogger(KafkaConsumerService.class);

	@Autowired
	 private RestTemplate restTemplate;
	
	@KafkaHandler
	public void consumePatientData(Patient patient) {
		logger.info("inside Kafka consumer service");
		Account employee = restTemplate.getForObject("http://localhost:8100/employee/" +patient.getId(), Account.class);
		
	}
}
