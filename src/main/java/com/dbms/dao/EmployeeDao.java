package com.dbms.dao;

import java.util.List;

import com.dbms.model.Employee;
public interface EmployeeDao {

	public List listAllEmployee();
	 
	 public void addEmployee(Employee employee);
	 
	 public void updateEmployee(Employee employee);
	 
	 public void deleteEmployee(int id);
	 
	 public Employee findEmployeeById(int id);
	
}