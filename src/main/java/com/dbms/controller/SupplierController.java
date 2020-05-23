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

import com.dbms.model.Supplier;

import com.dbms.service.SupplierService;
@RestController

@RequestMapping(value="/supplier")
public class SupplierController {

	@Autowired
	 SupplierService supplierService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("supplier/supplier_page");
	  
	  List list = supplierService.listAllSupplier();
	  model.addObject("listSupplier", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("supplier/supplier_form");
	  
	  Supplier supplier = new Supplier();
	  model.addObject("supplierForm", supplier);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("id") int id){
	  ModelAndView model = new ModelAndView("supplier/supplier_form");
	  
	  Supplier supplier = supplierService.findSupplierById(id);
	  model.addObject("supplierForm", supplier);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("supplierForm") Supplier supplier){
	  if(supplier != null && supplier.getSupplierId() != null){
	   supplierService.updateSupplier(supplier);
	  } else {
	   supplierService.addSupplier(supplier);
	  }
	  
	  return new ModelAndView("redirect:/supplier/list");
	 }
	 
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id){
	  supplierService.deleteSupplier(id);
	  
	  return new ModelAndView("redirect:/supplier/list");
	 }
	 @ExceptionHandler
	 public ModelAndView handleException(Exception e) {
		 ModelAndView model = new ModelAndView("error");
		 model.addObject("errorMessage",e.getMessage());
		 return model;
	 }
}
