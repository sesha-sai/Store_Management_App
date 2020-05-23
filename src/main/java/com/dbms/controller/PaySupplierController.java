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

import com.dbms.model.PaySupplier;

import com.dbms.service.PaySupplierService;
@RestController

@RequestMapping(value="/paySupplier")
public class PaySupplierController {

	@Autowired
	 PaySupplierService paySupplierService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("paySupplier/paySupplier_page");
	  
	  List list = paySupplierService.listAllPaySupplier();
	  model.addObject("listPaySupplier", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("paySupplier/paySupplier_form");
	  
	  PaySupplier paySupplier = new PaySupplier();
	  model.addObject("paySupplierForm", paySupplier);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("id") int id){
	  ModelAndView model = new ModelAndView("paySupplier/paySupplier_form");
	  
	  PaySupplier paySupplier = paySupplierService.findPaySupplierById(id);
	  model.addObject("paySupplierForm", paySupplier);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("paySupplierForm") PaySupplier paySupplier){
	  if(paySupplier != null && paySupplier.getPaySupplierId() != null){
	   paySupplierService.updatePaySupplier(paySupplier);
	  } else {
	   paySupplierService.addPaySupplier(paySupplier);
	  }
	  
	  return new ModelAndView("redirect:/paySupplier/list");
	 }
	 
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id){
	  paySupplierService.deletePaySupplier(id);
	  
	  return new ModelAndView("redirect:/paySupplier/list");
	 }
	 @ExceptionHandler
	 public ModelAndView handleException(Exception e) {
		 ModelAndView model = new ModelAndView("error");
		 model.addObject("errorMessage",e.getMessage());
		 return model;
	 }
}
