package com.dbms.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class InvoiceItem {
	@Id
	private Integer invoiceId;
	 private Integer itemId;
	 private Integer quantity;
	public InvoiceItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InvoiceItem(Integer invoiceId, Integer itemId) {
		super();
		this.invoiceId = invoiceId;
		this.itemId = itemId;
	}
	public Integer getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	 
}
