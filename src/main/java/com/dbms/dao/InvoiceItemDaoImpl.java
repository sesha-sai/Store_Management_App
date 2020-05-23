package com.dbms.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;


import com.dbms.model.InvoiceItem;

import org.springframework.jdbc.core.RowMapper;
@Repository
public class InvoiceItemDaoImpl implements InvoiceItemDao{
      NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
{
	this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
}

	 public List listAllInvoiceItem() {
		  String sql = "SELECT invoiceId,itemId,quantity FROM InvoiceItem";
		  
		  List list = namedParameterJdbcTemplate
		.query(sql, getSqlParameterByModel(null), new InvoiceItemMapper());
		  
		  return list;
		 }
   private SqlParameterSource getSqlParameterByModel(InvoiceItem invoiceItem)
   {
	   MapSqlParameterSource paramSource =new MapSqlParameterSource();
	   if(invoiceItem!= null)
	   {
		   paramSource.addValue("invoiceId", invoiceItem.getInvoiceId());
		   paramSource.addValue("itemId", invoiceItem.getItemId());
		   paramSource.addValue("quantity", invoiceItem.getQuantity());
		   
	   }
	   
	   
	   return paramSource;
   }
   private static final class InvoiceItemMapper implements RowMapper<InvoiceItem>
   {
	   public InvoiceItem mapRow(ResultSet rs,int rowNum) throws SQLException
	   {
		   InvoiceItem invoiceItem=new InvoiceItem();
		   invoiceItem.setInvoiceId(rs.getInt("invoiceId"));
		   invoiceItem.setItemId(rs.getInt("itemId"));
		   invoiceItem.setQuantity(rs.getInt("quantity"));
		   return invoiceItem;
	   }
   }
	@Override
	public void addInvoiceItem(InvoiceItem invoiceItem) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO InvoiceItem (invoiceId,itemId,quantity) values (:invoiceId,:itemId,:quantity)";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(invoiceItem));
	}

	@Override
	public InvoiceItem findInvoiceItemById(int invoiceId, int itemId) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM InvoiceItem WHERE invoiceItemId=:invoiceItemId";
		return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new InvoiceItem(invoiceId,itemId)),new InvoiceItemMapper() );
	}

	

}
  
