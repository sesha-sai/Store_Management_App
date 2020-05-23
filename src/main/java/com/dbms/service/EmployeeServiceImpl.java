package com.dbms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dbms.model.Employee;

import com.dbms.dao.EmployeeDao;

@Service
@Component
public class EmployeeServiceImpl implements EmployeeService {
 
 EmployeeDao employeeDao;
 
 @Autowired
 public void setEmployeeDao(EmployeeDao employeeDao) {
  this.employeeDao = employeeDao;
 }
 @Override
 public List listAllEmployee() {
  return employeeDao.listAllEmployee();
 }
 @Override
 public void addEmployee(Employee employee) {
  employeeDao.addEmployee(employee);
 }
 @Override
 public void updateEmployee(Employee employee) {
  employeeDao.updateEmployee(employee);
 }
 @Override
 public void deleteEmployee(int employeeId) {
  employeeDao.deleteEmployee(employeeId);
 }
 @Override
 public Employee findEmployeeById(int employeeId) {
  return employeeDao.findEmployeeById(employeeId);
 }

}
