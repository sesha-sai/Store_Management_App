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

import com.dbms.model.Wage;

import com.dbms.service.WageService;
@RestController

@RequestMapping(value="/wage")
public class WageController {

	@Autowired
	 WageService wageService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("wage/wage_page");
	  
	  List list = wageService.listAllWage();
	  model.addObject("listWage", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("wage/wage_form");
	  
	  Wage wage = new Wage();
	  model.addObject("wageForm", wage);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("id") int id){
	  ModelAndView model = new ModelAndView("wage/wage_form");
	  
	  Wage wage = wageService.findWageById(id);
	  model.addObject("wageForm", wage);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("wageForm") Wage wage){
	  if(wage != null && wage.getWageId() != null){
	   wageService.updateWage(wage);
	  } else {
	   wageService.addWage(wage);
	  }
	  
	  return new ModelAndView("redirect:/wage/list");
	 }
	 
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id){
	  wageService.deleteWage(id);
	  
	  return new ModelAndView("redirect:/wage/list");
	 }
	 @ExceptionHandler
	 public ModelAndView handleException(Exception e) {
		 ModelAndView model = new ModelAndView("error");
		 model.addObject("errorMessage",e.getMessage());
		 return model;
	 }
}
