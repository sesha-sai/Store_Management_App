package com.dbms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dbms.model.Employee;

import com.dbms.service.EmployeeService;
@RestController

@RequestMapping(value="/employee")
public class EmployeeController {

	@Autowired
	 EmployeeService employeeService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("employee/employee_page");
	  
	  List list = employeeService.listAllEmployee();
	  model.addObject("listEmployee", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("employee/employee_form");
	  
	  Employee employee = new Employee();
	  model.addObject("employeeForm", employee);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("id") int id){
	  ModelAndView model = new ModelAndView("employee/employee_form");
	  
	  Employee employee = employeeService.findEmployeeById(id);
	  model.addObject("employeeForm", employee);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("employeeForm") Employee employee){
	  if(employee != null && employee.getEmployeeId() != null){
	   employeeService.updateEmployee(employee);
	  } else {
	   employeeService.addEmployee(employee);
	  }
	  
	  return new ModelAndView("redirect:/employee/list");
	 }
	 
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id){
	  employeeService.deleteEmployee(id);
	  
	  return new ModelAndView("redirect:/employee/list");
	 }
	 @ExceptionHandler
	 public ModelAndView handleException(Exception e) {
		 ModelAndView model = new ModelAndView("error");
		 model.addObject("errorMessage",e.getMessage());
		 return model;
	 }
}
