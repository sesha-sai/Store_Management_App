package com.dbms.service;

import java.util.List;

import com.dbms.model.Brand;

public interface BrandService {

 public List listAllBrand();
 
 public void addBrand(Brand brand);
 
 public void updateBrand(Brand brand);
 
 public void deleteBrand(int brandId);
 
 public Brand findBrandById(int brandId);
}

