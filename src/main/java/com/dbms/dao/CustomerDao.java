package com.dbms.dao;

import java.util.List;

import com.dbms.model.Customer;
public interface CustomerDao {

	public List listAllCustomer();
	 
	 public void addCustomer(Customer customer);
	 
	 public void updateCustomer(Customer customer);
	 
	 public void deleteCustomer(int id);
	 
	 public Customer findCustomerById(int id);
	
}