package com.dbms.service;

import java.util.List;

import com.dbms.model.PaySupplier;

public interface PaySupplierService {

 public List listAllPaySupplier();
 
 public void addPaySupplier(PaySupplier paySupplier);
 
 public void updatePaySupplier(PaySupplier paySupplier);
 
 public void deletePaySupplier(int paySupplierId);
 
 public PaySupplier findPaySupplierById(int paySupplierId);
}

