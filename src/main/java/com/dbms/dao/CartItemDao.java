package com.dbms.dao;

import java.util.List;

import com.dbms.model.CartItem;
import com.dbms.model.InvoiceItem;
public interface CartItemDao {

	public List listAllCartItem();
	 
	 public void addCartItem(CartItem cartItem);
	 
	 public CartItem findCartItemById(int cartId,int itemId);
	
}