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

import com.dbms.model.Cart;

import com.dbms.service.CartService;
@RestController

@RequestMapping(value="/cart")
public class CartController {

	@Autowired
	 CartService cartService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("cart/cart_page");
	  
	  List list = cartService.listAllCart();
	  model.addObject("listCart", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("cart/cart_form");
	  
	  Cart cart = new Cart();
	  model.addObject("cartForm", cart);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("id") int id){
	  ModelAndView model = new ModelAndView("cart/cart_form");
	  
	  Cart cart = cartService.findCartById(id);
	  model.addObject("cartForm", cart);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("cartForm") Cart cart){
	  if(cart != null && cart.getCartId() != null){
	   cartService.updateCart(cart);
	  } else {
	   cartService.addCart(cart);
	  }
	  
	  return new ModelAndView("redirect:/cart/list");
	 }
	 
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id){
	  cartService.deleteCart(id);
	  
	  return new ModelAndView("redirect:/cart/list");
	 }
	 @ExceptionHandler
	 public ModelAndView handleException(Exception e) {
		 ModelAndView model = new ModelAndView("error");
		 model.addObject("errorMessage",e.getMessage());
		 return model;
	 }
}
