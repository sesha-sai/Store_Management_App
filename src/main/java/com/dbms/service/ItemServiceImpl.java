package com.dbms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dbms.model.Item;

import com.dbms.dao.ItemDao;

@Service
@Component
public class ItemServiceImpl implements ItemService {
 
 ItemDao itemDao;
 
 @Autowired
 public void setItemDao(ItemDao itemDao) {
  this.itemDao = itemDao;
 }
 @Override
 public List listAllItem() {
  return itemDao.listAllItem();
 }
 @Override
 public void addItem(Item item) {
  itemDao.addItem(item);
 }
 @Override
 public void updateItem(Item item) {
  itemDao.updateItem(item);
 }
 @Override
 public void deleteItem(int itemId) {
  itemDao.deleteItem(itemId);
 }
 @Override
 public Item findItemById(int itemId) {
  return itemDao.findItemById(itemId);
 }

}
