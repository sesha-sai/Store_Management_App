package com.dbms.service;

import java.util.List;

import com.dbms.model.InvoiceItem;

public interface InvoiceItemService {

 public List listAllInvoiceItem();
 
 public void addInvoiceItem(InvoiceItem invoiceItem);
 
 
 
 public InvoiceItem findInvoiceItemById(int invoiceId,int itemId);
}

