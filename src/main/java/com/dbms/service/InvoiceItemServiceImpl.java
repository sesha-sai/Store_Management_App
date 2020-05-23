package com.dbms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dbms.model.InvoiceItem;

import com.dbms.dao.InvoiceItemDao;

@Service
@Component
public class InvoiceItemServiceImpl implements InvoiceItemService {
 
 InvoiceItemDao invoiceItemDao;
 
 @Autowired
 public void setInvoiceItemDao(InvoiceItemDao invoiceItemDao) {
  this.invoiceItemDao = invoiceItemDao;
 }
 @Override
 public List listAllInvoiceItem() {
  return invoiceItemDao.listAllInvoiceItem();
 }
 @Override
 public void addInvoiceItem(InvoiceItem invoiceItem) {
  invoiceItemDao.addInvoiceItem(invoiceItem);
 }
 
 @Override
 public InvoiceItem findInvoiceItemById(int invoiceId,int itemId) {
  return invoiceItemDao.findInvoiceItemById(invoiceId,itemId);
 }

}
