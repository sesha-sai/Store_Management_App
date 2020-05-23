package com.dbms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dbms.model.Supplier;

import com.dbms.dao.SupplierDao;

@Service
@Component
public class SupplierServiceImpl implements SupplierService {
 
 SupplierDao supplierDao;
 
 @Autowired
 public void setSupplierDao(SupplierDao supplierDao) {
  this.supplierDao = supplierDao;
 }
 @Override
 public List listAllSupplier() {
  return supplierDao.listAllSupplier();
 }
 @Override
 public void addSupplier(Supplier supplier) {
  supplierDao.addSupplier(supplier);
 }
 @Override
 public void updateSupplier(Supplier supplier) {
  supplierDao.updateSupplier(supplier);
 }
 @Override
 public void deleteSupplier(int supplierId) {
  supplierDao.deleteSupplier(supplierId);
 }
 @Override
 public Supplier findSupplierById(int supplierId) {
  return supplierDao.findSupplierById(supplierId);
 }

}
