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

import com.dbms.model.Feedback;

import com.dbms.service.FeedbackService;
@RestController

@RequestMapping(value="/feedback")
public class FeedbackController {

	@Autowired
	 FeedbackService feedbackService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("feedback/feedback_page");
	  
	  List list = feedbackService.listAllFeedback();
	  model.addObject("listFeedback", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("feedback/feedback_form");
	  
	  Feedback feedback = new Feedback();
	  model.addObject("feedbackForm", feedback);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("id") int id){
	  ModelAndView model = new ModelAndView("feedback/feedback_form");
	  
	  Feedback feedback = feedbackService.findFeedbackById(id);
	  model.addObject("feedbackForm", feedback);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("feedbackForm") Feedback feedback){
	  if(feedback != null && feedback.getFeedbackId() != null){
	   feedbackService.updateFeedback(feedback);
	  } else {
	   feedbackService.addFeedback(feedback);
	  }
	  
	  return new ModelAndView("redirect:/feedback/list");
	 }
	 
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id){
	  feedbackService.deleteFeedback(id);
	  
	  return new ModelAndView("redirect:/feedback/list");
	 }
	 @ExceptionHandler
	 public ModelAndView handleException(Exception e) {
		 ModelAndView model = new ModelAndView("error");
		 model.addObject("errorMessage",e.getMessage());
		 return model;
	 }
}
