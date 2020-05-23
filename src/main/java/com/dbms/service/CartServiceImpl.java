package com.dbms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dbms.model.Cart;

import com.dbms.dao.CartDao;

@Service
@Component
public class CartServiceImpl implements CartService {
 
 CartDao cartDao;
 
 @Autowired
 public void setCartDao(CartDao cartDao) {
  this.cartDao = cartDao;
 }
 @Override
 public List listAllCart() {
  return cartDao.listAllCart();
 }
 @Override
 public void addCart(Cart cart) {
  cartDao.addCart(cart);
 }
 @Override
 public void updateCart(Cart cart) {
  cartDao.updateCart(cart);
 }
 @Override
 public void deleteCart(int cartId) {
  cartDao.deleteCart(cartId);
 }
 @Override
 public Cart findCartById(int cartId) {
  return cartDao.findCartById(cartId);
 }

}
