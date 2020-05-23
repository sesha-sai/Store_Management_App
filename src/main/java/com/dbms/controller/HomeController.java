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

@RequestMapping(value="/")
public class HomeController {

	@Autowired
	 
	 @RequestMapping(value="/", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView();
	  
	 model.setViewName("home_page");
	  
	  return model;
	 }
	 
}
