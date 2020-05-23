package com.dbms.dao;

import java.util.List;

import com.dbms.model.Wage;
public interface WageDao {

	public List listAllWage();
	 
	 public void addWage(Wage wage);
	 
	 public void updateWage(Wage wage);
	 
	 public void deleteWage(int id);
	 
	 public Wage findWageById(int id);
	
}