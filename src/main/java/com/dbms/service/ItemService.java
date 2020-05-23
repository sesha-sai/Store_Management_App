package com.dbms.service;

import java.util.List;

import com.dbms.model.Item;

public interface ItemService {

 public List listAllItem();
 
 public void addItem(Item item);
 
 public void updateItem(Item item);
 
 public void deleteItem(int itemId);
 
 public Item findItemById(int itemId);
}

