package com.dbms.dao;

import java.util.List;

import com.dbms.model.PaySupplier;
public interface PaySupplierDao {

	public List listAllPaySupplier();
	 
	 public void addPaySupplier(PaySupplier paySupplier);
	 
	 public void updatePaySupplier(PaySupplier paySupplier);
	 
	 public void deletePaySupplier(int id);
	 
	 public PaySupplier findPaySupplierById(int id);
	
}