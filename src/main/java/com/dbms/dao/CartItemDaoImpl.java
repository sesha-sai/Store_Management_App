package com.dbms.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;


import com.dbms.model.CartItem;

import org.springframework.jdbc.core.RowMapper;
@Repository
public class CartItemDaoImpl implements CartItemDao{
      NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
{
	this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
}

	 public List listAllCartItem() {
		  String sql = "SELECT * FROM CartItem";
		  
		  List list = namedParameterJdbcTemplate
		.query(sql, getSqlParameterByModel(null), new CartItemMapper());
		  
		  return list;
		 }
   private SqlParameterSource getSqlParameterByModel(CartItem cartItem)
   {
	   MapSqlParameterSource paramSource =new MapSqlParameterSource();
	   if(cartItem!= null)
	   {
		   paramSource.addValue("cartId", cartItem.getCartId());
		   paramSource.addValue("itemId", cartItem.getItemId());
		   paramSource.addValue("quantity", cartItem.getQuantity());
		   
	   }
	   
	   
	   return paramSource;
   }
   private static final class CartItemMapper implements RowMapper<CartItem>
   {
	   public CartItem mapRow(ResultSet rs,int rowNum) throws SQLException
	   {
		   CartItem cartItem=new CartItem();
		   cartItem.setCartId(rs.getInt("cartId"));
		   cartItem.setItemId(rs.getInt("itemId"));
		   cartItem.setQuantity(rs.getInt("quantity"));
		   return cartItem;
	   }
   }
	@Override
	public void addCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO CartItem (cartId,itemId,quantity) values (:cartId,:itemId,:quantity)";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(cartItem));
	}

	@Override
	public CartItem findCartItemById(int cartId, int itemId) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM InvoiceItem WHERE invoiceItemId=:invoiceItemId";
		return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new CartItem(cartId,itemId)),new CartItemMapper() );
	}

	

}
  
