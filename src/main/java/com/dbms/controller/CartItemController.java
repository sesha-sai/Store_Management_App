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

import com.dbms.model.CartItem;

import com.dbms.service.CartItemService;
@RestController

@RequestMapping(value="/cartItem")
public class CartItemController {

	@Autowired
	 CartItemService cartItemService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("cartItem/cartItem_page");
	  
	  List list = cartItemService.listAllCartItem();
	  model.addObject("listCartItem", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("cartItem/cartItem_form");
	  
	  CartItem cartItem = new CartItem();
	  model.addObject("cartItemForm", cartItem);
	  
	  return model;
	 }
	 
	 
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("cartItemForm") CartItem cartItem){
	  
	   cartItemService.addCartItem(cartItem);
	  
	  return new ModelAndView("redirect:/cartItem/list");
	 }
	 
	 @ExceptionHandler
	 public ModelAndView handleException(Exception e) {
		 ModelAndView model = new ModelAndView("error");
		 model.addObject("errorMessage",e.getMessage());
		 return model;
	 }
}
