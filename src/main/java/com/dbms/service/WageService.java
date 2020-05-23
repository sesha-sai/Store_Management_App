package com.dbms.service;

import java.util.List;

import com.dbms.model.Wage;

public interface WageService {

 public List listAllWage();
 
 public void addWage(Wage wage);
 
 public void updateWage(Wage wage);
 
 public void deleteWage(int wageId);
 
 public Wage findWageById(int wageId);
}

