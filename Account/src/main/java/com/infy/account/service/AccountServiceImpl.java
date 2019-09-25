package com.infy.account.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.infy.account.dao.AccountDAO;
import com.infy.account.entity.Account;

public class AccountServiceImpl {

	@Autowired
	AccountDAO accountDao;

	public Account getEmpDetails(Integer empId) {

		Account employee = new Account();
		employee = accountDao.getEmployeeById(empId);

		if (employee.equals(null)) {

			employee.setEmpId(0705);
			employee.setEmpName("Sai");
			employee.setSalary(10000);
		} else {
			employee.setEmpId(employee.getEmpId());
			employee.setEmpName(employee.getEmpName());
			employee.setSalary(employee.getSalary());

		}
		return employee;

	}

}
