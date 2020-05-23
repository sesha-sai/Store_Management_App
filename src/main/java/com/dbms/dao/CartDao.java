package com.dbms.dao;

import java.util.List;

import com.dbms.model.Cart;
public interface CartDao {

	public List listAllCart();
	 
	 public void addCart(Cart cart);
	 
	 public void updateCart(Cart cart);
	 
	 public void deleteCart(int id);
	 
	 public Cart findCartById(int id);
	
}