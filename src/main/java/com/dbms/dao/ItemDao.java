package com.dbms.dao;

import java.util.List;

import com.dbms.model.Item;
public interface ItemDao {

	public List listAllItem();
	 
	 public void addItem(Item item);
	 
	 public void updateItem(Item item);
	 
	 public void deleteItem(int id);
	 
	 public Item findItemById(int id);
	
}