package com.dbms.service;

import java.util.List;

import com.dbms.model.Cart;

public interface CartService {

 public List listAllCart();
 
 public void addCart(Cart cart);
 
 public void updateCart(Cart cart);
 
 public void deleteCart(int cartId);
 
 public Cart findCartById(int cartId);
}

