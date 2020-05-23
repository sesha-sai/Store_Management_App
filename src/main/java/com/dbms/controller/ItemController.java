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

import com.dbms.model.Item;

import com.dbms.service.ItemService;
@RestController

@RequestMapping(value="/item")
public class ItemController {

	@Autowired
	 ItemService itemService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("item/item_page");
	  
	  List list = itemService.listAllItem();
	  model.addObject("listItem", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("item/item_form");
	  
	  Item item = new Item();
	  model.addObject("itemForm", item);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("id") int id){
	  ModelAndView model = new ModelAndView("item/item_form");
	  
	  Item item = itemService.findItemById(id);
	  model.addObject("itemForm", item);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("itemForm") Item item){
	  if(item != null && item.getItemId() != null){
	   itemService.updateItem(item);
	  } else {
	   itemService.addItem(item);
	  }
	  
	  return new ModelAndView("redirect:/item/list");
	 }
	 
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id){
	  itemService.deleteItem(id);
	  
	  return new ModelAndView("redirect:/item/list");
	 }
	 @ExceptionHandler
	 public ModelAndView handleException(Exception e) {
		 ModelAndView model = new ModelAndView("error");
		 model.addObject("errorMessage",e.getMessage());
		 return model;
	 }
}
