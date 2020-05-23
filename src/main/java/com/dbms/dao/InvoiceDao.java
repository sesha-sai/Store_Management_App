package com.dbms.dao;

import java.util.List;

import com.dbms.model.Invoice;
public interface InvoiceDao {

	public List listAllInvoice();
	 
	 public void addInvoice(Invoice invoice);
	 
	 public void updateInvoice(Invoice invoice);
	 
	 public void deleteInvoice(int id);
	 
	 public Invoice findInvoiceById(int id);
	
}