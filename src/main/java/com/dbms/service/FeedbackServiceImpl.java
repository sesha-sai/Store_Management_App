package com.dbms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dbms.model.Feedback;

import com.dbms.dao.FeedbackDao;

@Service
@Component
public class FeedbackServiceImpl implements FeedbackService {
 
 FeedbackDao feedbackDao;
 
 @Autowired
 public void setFeedbackDao(FeedbackDao feedbackDao) {
  this.feedbackDao = feedbackDao;
 }
 @Override
 public List listAllFeedback() {
  return feedbackDao.listAllFeedback();
 }
 @Override
 public void addFeedback(Feedback feedback) {
  feedbackDao.addFeedback(feedback);
 }
 @Override
 public void updateFeedback(Feedback feedback) {
  feedbackDao.updateFeedback(feedback);
 }
 @Override
 public void deleteFeedback(int feedbackId) {
  feedbackDao.deleteFeedback(feedbackId);
 }
 @Override
 public Feedback findFeedbackById(int feedbackId) {
  return feedbackDao.findFeedbackById(feedbackId);
 }

}
