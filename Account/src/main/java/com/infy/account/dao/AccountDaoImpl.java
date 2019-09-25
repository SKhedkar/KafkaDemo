package com.infy.account.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.infy.account.entity.Account;

public class AccountDaoImpl {
	
	static final Logger logger = Logger.getLogger(AccountDaoImpl.class);

	@Autowired
	private SessionFactory sessionfactory;
	Session session = null;

	public Account getEmployeeById(int id) {
		session = sessionfactory.openSession();
		session.beginTransaction();
		Account employee = session.get(Account.class, id);

		session.getTransaction().commit();
		session.close();
		return employee;
	}

}
