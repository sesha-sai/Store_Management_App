package com.dbms.service;

import java.util.List;

import com.dbms.model.Supplier;

public interface SupplierService {

 public List listAllSupplier();
 
 public void addSupplier(Supplier supplier);
 
 public void updateSupplier(Supplier supplier);
 
 public void deleteSupplier(int supplierId);
 
 public Supplier findSupplierById(int supplierId);
}

