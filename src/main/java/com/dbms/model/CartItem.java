package com.dbms.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class CartItem {
	@Id
	private Integer cartId;
	 private Integer itemId;
	 private Integer quantity;
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartItem(Integer cartId, Integer itemId) {
		super();
		this.cartId = cartId;
		this.itemId = itemId;
	}
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	 
	 
	
}
