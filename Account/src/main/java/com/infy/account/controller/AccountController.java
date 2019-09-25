package com.infy.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.infy.account.entity.Account;
import com.infy.account.service.AccountService;

@RestController
public class AccountController {
	
	static final Logger logger = Logger.getLogger(AccountController.class);

	@Autowired
	AccountService accountService;

	@RequestMapping(value = "/employee/{EMP_ID}", method = RequestMethod.GET)
	public Account getDetails(@PathVariable Integer employeeId) {
		logger.info("Inside controller");
		return accountService.getEmpDetails(employeeId);

	}
}
