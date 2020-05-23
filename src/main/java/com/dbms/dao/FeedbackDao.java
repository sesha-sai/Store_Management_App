package com.dbms.dao;

import java.util.List;

import com.dbms.model.Feedback;
public interface FeedbackDao {

	public List listAllFeedback();
	 
	 public void addFeedback(Feedback feedback);
	 
	 public void updateFeedback(Feedback feedback);
	 
	 public void deleteFeedback(int id);
	 
	 public Feedback findFeedbackById(int id);
	
}