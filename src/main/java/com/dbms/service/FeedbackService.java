package com.dbms.service;

import java.util.List;

import com.dbms.model.Feedback;

public interface FeedbackService {

 public List listAllFeedback();
 
 public void addFeedback(Feedback feedback);
 
 public void updateFeedback(Feedback feedback);
 
 public void deleteFeedback(int feedbackId);
 
 public Feedback findFeedbackById(int feedbackId);
}

