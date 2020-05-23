package com.dbms.dao;

import java.util.List;

import com.dbms.model.InvoiceItem;
public interface InvoiceItemDao {

	public List listAllInvoiceItem();
	 
	 public void addInvoiceItem(InvoiceItem invoiceItem);
	 
	 
	 
	 public InvoiceItem findInvoiceItemById(int invoiceId,int itemId);
	
}