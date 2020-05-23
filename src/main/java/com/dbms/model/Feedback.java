package com.dbms.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Feedback {
	@Id
	private Integer feedbackId;
	 private Integer customerId;
	 private String date;
	 private String remarks;
	 
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Feedback(Integer feedbackId) {
		super();
		this.feedbackId = feedbackId;
	}


	public Integer getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	 
}
