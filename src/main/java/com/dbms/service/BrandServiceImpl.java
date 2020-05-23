package com.dbms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dbms.model.Brand;

import com.dbms.dao.BrandDao;

@Service
@Component
public class BrandServiceImpl implements BrandService {
 
 BrandDao brandDao;
 
 @Autowired
 public void setBrandDao(BrandDao brandDao) {
  this.brandDao = brandDao;
 }
 @Override
 public List listAllBrand() {
  return brandDao.listAllBrand();
 }
 @Override
 public void addBrand(Brand brand) {
  brandDao.addBrand(brand);
 }
 @Override
 public void updateBrand(Brand brand) {
  brandDao.updateBrand(brand);
 }
 @Override
 public void deleteBrand(int brandId) {
  brandDao.deleteBrand(brandId);
 }
 @Override
 public Brand findBrandById(int brandId) {
  return brandDao.findBrandById(brandId);
 }

}
