package com.hms.Dao;

import com.hms.Customers;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {
	Customers createCustomers(Customers customers);	
	List<Customers> getAllCustomers();
	
	Optional<Customers> findById(Long cust_id);
	Customers updateCustomers(Long cust_id,Customers updatedCustomers);
	void deleteCustomers(Long cust_id);
	Customers getCustomers(Long cust_id);
}
