package com.dbms.dao;

import java.util.List;

import com.dbms.model.Supplier;
public interface SupplierDao {

	public List listAllSupplier();
	 
	 public void addSupplier(Supplier supplier);
	 
	 public void updateSupplier(Supplier supplier);
	 
	 public void deleteSupplier(int id);
	 
	 public Supplier findSupplierById(int id);
	
}