package com.dbms.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class PaySupplier {
	@Id
	private Integer paySupplierId;
	 private Integer supplierId;
	 private Integer amount;
	 private String date;
	public PaySupplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaySupplier(Integer paySupplierId) {
		super();
		this.paySupplierId = paySupplierId;
	}
	public Integer getPaySupplierId() {
		return paySupplierId;
	}
	public void setPaySupplierId(Integer paySupplierId) {
		this.paySupplierId = paySupplierId;
	}
	public Integer getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
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
