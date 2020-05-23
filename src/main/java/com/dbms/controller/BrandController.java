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

import com.dbms.model.Brand;

import com.dbms.service.BrandService;
@RestController

@RequestMapping(value="/brand")
public class BrandController {

	@Autowired
	 BrandService brandService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("brand/brand_page");
	  
	  List list = brandService.listAllBrand();
	  model.addObject("listBrand", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("brand/brand_form");
	  
	  Brand brand = new Brand();
	  model.addObject("brandForm", brand);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("id") int id){
	  ModelAndView model = new ModelAndView("brand/brand_form");
	  
	  Brand brand = brandService.findBrandById(id);
	  model.addObject("brandForm", brand);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("brandForm") Brand brand){
	  if(brand != null && brand.getBrandId() != null){
	   brandService.updateBrand(brand);
	  } else {
	   brandService.addBrand(brand);
	  }
	  
	  return new ModelAndView("redirect:/brand/list");
	 }
	 
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id){
	  brandService.deleteBrand(id);
	  
	  return new ModelAndView("redirect:/brand/list");
	 }
	 @ExceptionHandler
	 public ModelAndView handleException(Exception e) {
		 ModelAndView model = new ModelAndView("error");
		 model.addObject("errorMessage",e.getMessage());
		 return model;
	 }
}
