package com.howtodoinjava.hibernate.test;

import org.hibernate.Session;

import com.howtodoinjava.hibernate.test.dto.EmployeeEntity;

public class TestHibernate {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		// Add new Employee object
		EmployeeEntity emp = new EmployeeEntity();
		emp.setEmail("abc-user@mail.com");
		emp.setFirstName("abc");
		emp.setLastName("abc");

		session.persist(emp);

		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}

}
