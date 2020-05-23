package com.dbms.service;

import java.util.List;

import com.dbms.model.CartItem;

public interface CartItemService {

 public List listAllCartItem();
 
 public void addCartItem(CartItem cartItem);
 
 
 public CartItem findCartItemById(int cartId,int itemId );
}

