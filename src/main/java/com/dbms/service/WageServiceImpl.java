package com.dbms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dbms.model.Wage;

import com.dbms.dao.WageDao;

@Service
@Component
public class WageServiceImpl implements WageService {
 
 WageDao wageDao;
 
 @Autowired
 public void setWageDao(WageDao wageDao) {
  this.wageDao = wageDao;
 }
 @Override
 public List listAllWage() {
  return wageDao.listAllWage();
 }
 @Override
 public void addWage(Wage wage) {
  wageDao.addWage(wage);
 }
 @Override
 public void updateWage(Wage wage) {
  wageDao.updateWage(wage);
 }
 @Override
 public void deleteWage(int wageId) {
  wageDao.deleteWage(wageId);
 }
 @Override
 public Wage findWageById(int wageId) {
  return wageDao.findWageById(wageId);
 }

}
