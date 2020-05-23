package com.dbms.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Wage {
	@Id
	private Integer wageId;
	 private Integer employeeId;
	 private Integer amount;
	 private String date;
	public Wage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Wage(Integer wageId) {
		super();
		this.wageId = wageId;
	}
	public Integer getWageId() {
		return wageId;
	}
	public void setWageId(Integer wageId) {
		this.wageId = wageId;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	 
}
