package com.dbms.service;

import java.util.List;

import com.dbms.model.Customer;

public interface CustomerService {

 public List listAllCustomer();
 
 public void addCustomer(Customer customer);
 
 public void updateCustomer(Customer customer);
 
 public void deleteCustomer(int customerId);
 
 public Customer findCustomerById(int customerId);
}

