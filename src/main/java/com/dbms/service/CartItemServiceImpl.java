package com.dbms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dbms.model.CartItem;

import com.dbms.dao.CartItemDao;

@Service
@Component
public class CartItemServiceImpl implements CartItemService {
 
 CartItemDao cartItemDao;
 
 @Autowired
 public void setCartItemDao(CartItemDao cartItemDao) {
  this.cartItemDao = cartItemDao;
 }
 @Override
 public List listAllCartItem() {
  return cartItemDao.listAllCartItem();
 }
 @Override
 public void addCartItem(CartItem cartItem) {
  cartItemDao.addCartItem(cartItem);
 }
 
 @Override
 public CartItem findCartItemById(int cartId,int itemId) {
  return cartItemDao.findCartItemById(cartId,itemId);
 }

}
