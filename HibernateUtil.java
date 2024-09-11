package com.hms.util;
import org.hibernate.Session;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import com.hms.Customers;
import com.hms.Department;
import com.hms.Drivers;
import com.hms.Employees;
import com.hms.Food;
import com.hms.Room;
import com.hms.BookingRoom;
public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static SessionFactory buildSessionFactory() {
		try {
			return new
					Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Room.class).addAnnotatedClass(Customers.class)
					.addAnnotatedClass(Drivers.class).addAnnotatedClass(Food.class).addAnnotatedClass(Department.class)
					.addAnnotatedClass(Employees.class).addAnnotatedClass(BookingRoom.class)
					.buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session getSession()
	{
	  return getSessionFactory().openSession(); //session opened
	}
}