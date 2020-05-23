package com.dbms.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.dbms.model.Item;

import org.springframework.jdbc.core.RowMapper;
@Repository
public class ItemDaoImpl implements ItemDao{
      NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
{
	this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
}

	 public List listAllItem() {
		  String sql = "SELECT * FROM Item";
		  
		  List list = namedParameterJdbcTemplate
		.query(sql, getSqlParameterByModel(null), new ItemMapper());
		  
		  return list;
		 }
   private SqlParameterSource getSqlParameterByModel(Item item)
   {
	   MapSqlParameterSource paramSource =new MapSqlParameterSource();
	   if(item!= null)
	   {
		   paramSource.addValue("itemId", item.getItemId());
		   paramSource.addValue("name", item.getName());
		   paramSource.addValue("size", item.getSize());
		   paramSource.addValue("brandId", item.getBrandId());
		   paramSource.addValue("buyingPrice", item.getBuyingPrice());
		   paramSource.addValue("sellingPrice", item.getSellingPrice());
		   paramSource.addValue("colour", item.getColour());
		   paramSource.addValue("quantity", item.getQuantity());
	   }
	   
	   
	   return paramSource;
   }
   private static final class ItemMapper implements RowMapper<Item>
   {
	   public Item mapRow(ResultSet rs,int rowNum) throws SQLException
	   {
		   Item item=new Item();
		   item.setItemId(rs.getInt("itemId"));
		   item.setName(rs.getString("name"));
		   item.setSize(rs.getInt("size"));
		   item.setBrandId(rs.getInt("brandId"));
		   item.setBuyingPrice(rs.getInt("buyingPrice"));
		   item.setSellingPrice(rs.getInt("sellingPrice"));
		   item.setColour(rs.getString("colour"));
		   item.setQuantity(rs.getInt("quantity"));
		   return item;
		   
	   }
   }
	@Override
	public void addItem(Item item) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO Item (name,size,brandId,buyingPrice,sellingPrice,colour,quantity) values (:name,:size,:brandId,:buyingPrice,:sellingPrice,:colour,:quantity)";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(item));
	}

	@Override
	public void updateItem(Item item) {
		// TODO Auto-generated method stub
		String sql="UPDATE Item set name=:name,size=:size ,brandId= :brandId,buyingPrice=:buyingPrice,sellingPrice=:sellingPrice,colour=:colour,quantity=:quantity where itemId=:itemId";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(item));
		 
	}

	@Override
	public void deleteItem(int itemId) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM Item WHERE itemId=:itemId";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Item(itemId)));
		
	}

	@Override
	public Item findItemById(int itemId) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM Item WHERE itemId=:itemId";
	return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Item(itemId)),new ItemMapper() );
		
	}
	

}
  
