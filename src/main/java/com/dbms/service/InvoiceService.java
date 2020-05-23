package com.dbms.service;

import java.util.List;

import com.dbms.model.Invoice;

public interface InvoiceService {

 public List listAllInvoice();
 
 public void addInvoice(Invoice invoice);
 
 public void updateInvoice(Invoice invoice);
 
 public void deleteInvoice(int invoiceId);
 
 public Invoice findInvoiceById(int invoiceId);
}

