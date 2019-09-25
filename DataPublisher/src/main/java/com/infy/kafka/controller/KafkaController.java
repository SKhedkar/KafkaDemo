package com.infy.kafka.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.infy.kafka.service.KafkaSender;

@RestController

public class KafkaController {
	
	static final Logger logger = Logger.getLogger(KafkaController.class);

	@Autowired
	KafkaSender kafkaSender;

	@GetMapping(value = "/producer")
	public String sendPatientData() {

		try {
			logger.info("publish to kafka");
			return kafkaSender.publishDataToKafka();
			
		} catch (Exception e) {
			logger.debug("Error occured" + e.getMessage());
		}

		return "Data published on kafka topic successfully";
	}


}
