package com.dbms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dbms.model.Customer;

import com.dbms.dao.CustomerDao;

@Service
@Component
public class CustomerServiceImpl implements CustomerService {
 
 CustomerDao customerDao;
 
 @Autowired
 public void setCustomerDao(CustomerDao customerDao) {
  this.customerDao = customerDao;
 }
 @Override
 public List listAllCustomer() {
  return customerDao.listAllCustomer();
 }
 @Override
 public void addCustomer(Customer customer) {
  customerDao.addCustomer(customer);
 }
 @Override
 public void updateCustomer(Customer customer) {
  customerDao.updateCustomer(customer);
 }
 @Override
 public void deleteCustomer(int customerId) {
  customerDao.deleteCustomer(customerId);
 }
 @Override
 public Customer findCustomerById(int customerId) {
  return customerDao.findCustomerById(customerId);
 }

}
