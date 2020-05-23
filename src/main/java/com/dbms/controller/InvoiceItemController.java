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

import com.dbms.model.InvoiceItem;

import com.dbms.service.InvoiceItemService;
@RestController

@RequestMapping(value="/invoiceItem")
public class InvoiceItemController {

	@Autowired
	 InvoiceItemService invoiceItemService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("invoiceItem/invoiceItem_page");
	  
	  List list = invoiceItemService.listAllInvoiceItem();
	  model.addObject("listInvoiceItem", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("invoiceItem/invoiceItem_form");
	  
	  InvoiceItem invoiceItem = new InvoiceItem();
	  model.addObject("invoiceItemForm", invoiceItem);
	  
	  return model;
	 }
	 
	
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("invoiceItemForm") InvoiceItem invoiceItem){
	  
	   invoiceItemService.addInvoiceItem(invoiceItem);
	  
	  return new ModelAndView("redirect:/invoiceItem/list");
	 }
	 @ExceptionHandler
	 public ModelAndView handleException(Exception e) {
		 ModelAndView model = new ModelAndView("error");
		 model.addObject("errorMessage",e.getMessage());
		 return model;
	 }
	
}
