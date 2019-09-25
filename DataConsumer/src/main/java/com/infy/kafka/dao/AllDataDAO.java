package com.infy.kafka.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infy.entity.Employee;

@Repository
public class AllDataDAO {
	
	static final Logger logger = Logger.getLogger(AllDataDAO.class);

	@Autowired
	private SessionFactory sessionfactory;
	Session session = null;

	public void saveAllDetails(int id, String name, String dept) {
		session = sessionfactory.openSession();
		session.beginTransaction();
		Employee allData = new Employee();
		allData.setId(id);
		allData.setName(name);
		allData.setDept(dept);
		session.save(allData);

		session.getTransaction().commit();
		session.close();
	}

}
