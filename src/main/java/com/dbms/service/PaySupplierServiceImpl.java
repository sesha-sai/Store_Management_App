package com.dbms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dbms.model.PaySupplier;

import com.dbms.dao.PaySupplierDao;

@Service
@Component
public class PaySupplierServiceImpl implements PaySupplierService {
 
 PaySupplierDao paySupplierDao;
 
 @Autowired
 public void setPaySupplierDao(PaySupplierDao paySupplierDao) {
  this.paySupplierDao = paySupplierDao;
 }
 @Override
 public List listAllPaySupplier() {
  return paySupplierDao.listAllPaySupplier();
 }
 @Override
 public void addPaySupplier(PaySupplier paySupplier) {
  paySupplierDao.addPaySupplier(paySupplier);
 }
 @Override
 public void updatePaySupplier(PaySupplier paySupplier) {
  paySupplierDao.updatePaySupplier(paySupplier);
 }
 @Override
 public void deletePaySupplier(int paySupplierId) {
  paySupplierDao.deletePaySupplier(paySupplierId);
 }
 @Override
 public PaySupplier findPaySupplierById(int paySupplierId) {
  return paySupplierDao.findPaySupplierById(paySupplierId);
 }

}
