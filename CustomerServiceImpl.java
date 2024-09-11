package com.hms.serviceImp;


import com.hms.Customers;

import com.hms.Dao.CustomerDao;
import com.hms.DaoImp.CustomerDaoImpl;
import Services.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

	CustomerDao customerDao =new CustomerDaoImpl();
	
	@Override
	public Customers createCustomer(Customers customers) {
		//invoke daoimple method to save student object
		
		return customerDao.createCustomers(customers);
	
	}

	@Override
	public List<Customers> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerDao.getAllCustomers();
	}

	@Override
	public Customers getCustomer(Long custId) {
		// TODO Auto-generated method stub
		return customerDao.getCustomers(custId);
	}


	@Override
	public Customers updateCustomer(Long custId, Customers updatedCustomers) {
		
		return customerDao.updateCustomers(custId, updatedCustomers);
	}

	@Override
	public void deleteCustomer(Long custId) {
		 customerDao.deleteCustomers(custId);
	}

}
