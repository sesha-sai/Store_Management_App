package com.dbms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dbms.model.Invoice;

import com.dbms.dao.InvoiceDao;

@Service
@Component
public class InvoiceServiceImpl implements InvoiceService {
 
 InvoiceDao invoiceDao;
 
 @Autowired
 public void setInvoiceDao(InvoiceDao invoiceDao) {
  this.invoiceDao = invoiceDao;
 }
 @Override
 public List listAllInvoice() {
  return invoiceDao.listAllInvoice();
 }
 @Override
 public void addInvoice(Invoice invoice) {
  invoiceDao.addInvoice(invoice);
 }
 @Override
 public void updateInvoice(Invoice invoice) {
  invoiceDao.updateInvoice(invoice);
 }
 @Override
 public void deleteInvoice(int invoiceId) {
  invoiceDao.deleteInvoice(invoiceId);
 }
 @Override
 public Invoice findInvoiceById(int invoiceId) {
  return invoiceDao.findInvoiceById(invoiceId);
 }

}
