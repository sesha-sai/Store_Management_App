package com.dbms.dao;

import java.util.List;

import com.dbms.model.Brand;
public interface BrandDao {

	public List listAllBrand();
	 
	 public void addBrand(Brand brand);
	 
	 public void updateBrand(Brand brand);
	 
	 public void deleteBrand(int id);
	 
	 public Brand findBrandById(int id);
	
}