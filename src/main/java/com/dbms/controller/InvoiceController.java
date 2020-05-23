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

import com.dbms.model.Invoice;

import com.dbms.service.InvoiceService;
@RestController

@RequestMapping(value="/invoice")
public class InvoiceController {

	@Autowired
	 InvoiceService invoiceService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("invoice/invoice_page");
	  
	  List list = invoiceService.listAllInvoice();
	  model.addObject("listInvoice", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("invoice/invoice_form");
	  
	  Invoice invoice = new Invoice();
	  model.addObject("invoiceForm", invoice);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("id") int id){
	  ModelAndView model = new ModelAndView("invoice/invoice_form");
	  
	  Invoice invoice = invoiceService.findInvoiceById(id);
	  model.addObject("invoiceForm", invoice);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("invoiceForm") Invoice invoice){
	  if(invoice != null && invoice.getInvoiceId() != null){
	   invoiceService.updateInvoice(invoice);
	  } else {
	   invoiceService.addInvoice(invoice);
	  }
	  
	  return new ModelAndView("redirect:/invoice/list");
	 }
	 
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id){
	  invoiceService.deleteInvoice(id);
	  
	  return new ModelAndView("redirect:/invoice/list");
	 }
	 @ExceptionHandler
	 public ModelAndView handleException(Exception e) {
		 ModelAndView model = new ModelAndView("error");
		 model.addObject("errorMessage",e.getMessage());
		 return model;
	 }
}
