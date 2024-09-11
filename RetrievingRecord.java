package com.hms;
import com.hms.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
public class RetrievingRecord{
public static void main(String[] args){
// Obtain a Hibernate SessionFactory
SessionFactory factory = HibernateUtil.getSessionFactory();
// Open a new session
Session session = factory.openSession();
// Begin a transaction
Transaction transaction = session.beginTransaction();
/*
// Retrieve the object using the primary key
Room r1=session.get(Room.class, "102");
//display data using toString() method
System.out.println(r1);

//Retrieve the object using the primary key
Customers c1=session.get(Customers.class, "Cust_01");
//display data using toString() method
System.out.println(c1);

//Retrieve the object using the primary key
Employees e1=session.get(Employees.class, "123456789123");
//display data using toString() method
System.out.println(c1);

//Retrieve the object using the primary key
Drivers d1=session.get(Drivers.class, "Driver_01");
//display data using toString() method
System.out.println(c1);
*/
//Retrieve the object using the primary key
//Food f1=session.get(Food.class, "Food_01");
//display data using toString() method
//System.out.println(f1);

// Commit the transaction
transaction.commit();
// Close the session
session.close();
} 
} 