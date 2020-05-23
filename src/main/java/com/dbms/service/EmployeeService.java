package com.dbms.service;

import java.util.List;

import com.dbms.model.Employee;

public interface EmployeeService {

 public List listAllEmployee();
 
 public void addEmployee(Employee employee);
 
 public void updateEmployee(Employee employee);
 
 public void deleteEmployee(int employeeId);
 
 public Employee findEmployeeById(int employeeId);
}

