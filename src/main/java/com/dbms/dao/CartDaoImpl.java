package com.dbms.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.dbms.model.Cart;

import org.springframework.jdbc.core.RowMapper;
@Repository
public class CartDaoImpl implements CartDao{
      NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
{
	this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
}

	 public List listAllCart() {
		  String sql = "SELECT * FROM Cart";
		  
		  List list = namedParameterJdbcTemplate
		.query(sql, getSqlParameterByModel(null), new CartMapper());
		  
		  return list;
		 }
   private SqlParameterSource getSqlParameterByModel(Cart cart)
   {
	   MapSqlParameterSource paramSource =new MapSqlParameterSource();
	   if(cart!= null)
	   {
		   paramSource.addValue("cartId", cart.getCartId());
		   paramSource.addValue("customerId", cart.getCustomerId());
		   paramSource.addValue("amount", cart.getAmount());
		   paramSource.addValue("date", cart.getDate());
		   
	   }
	   
	   
	   return paramSource;
   }
   private static final class CartMapper implements RowMapper<Cart>
   {
	   public Cart mapRow(ResultSet rs,int rowNum) throws SQLException
	   {
		   Cart cart=new Cart();
		   cart.setCartId(rs.getInt("cartId"));
		   cart.setCustomerId(rs.getInt("customerId"));
		   cart.setAmount(rs.getInt("amount"));
		   cart.setDate(rs.getString("date"));
		   return cart;
		   
	   }
   }
	@Override
	public void addCart(Cart cart) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO Cart (customerId,amount,date) values (:customerId,:amount,:date)";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(cart));
	}

	@Override
	public void updateCart(Cart cart) {
		// TODO Auto-generated method stub
		String sql="UPDATE Cart set customerId= :customerId,amount=:amount,date=:date where cartId=:cartId";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(cart));
		 
	}

	@Override
	public void deleteCart(int cartId) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM Cart WHERE cartId=:cartId";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Cart(cartId)));
		
	}

	@Override
	public Cart findCartById(int cartId) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM Cart WHERE cartId=:cartId";
	return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Cart(cartId)),new CartMapper() );
		
	}
	

}
  
