package com.dbms.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.dbms.model.Invoice;

import org.springframework.jdbc.core.RowMapper;
@Repository
public class InvoiceDaoImpl implements InvoiceDao{
      NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
{
	this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
}

	 public List listAllInvoice() {
		  String sql = "SELECT invoiceId,supplierId,amount,date FROM Invoice";
		  
		  List list = namedParameterJdbcTemplate
		.query(sql, getSqlParameterByModel(null), new InvoiceMapper());
		  
		  return list;
		 }
   private SqlParameterSource getSqlParameterByModel(Invoice invoice)
   {
	   MapSqlParameterSource paramSource =new MapSqlParameterSource();
	   if(invoice!= null)
	   {
		   paramSource.addValue("invoiceId", invoice.getInvoiceId());
		   paramSource.addValue("supplierId", invoice.getSupplierId());
		   paramSource.addValue("amount", invoice.getAmount());
		   paramSource.addValue("date", invoice.getDate());
		   
	   }
	   
	   
	   return paramSource;
   }
   private static final class InvoiceMapper implements RowMapper<Invoice>
   {
	   public Invoice mapRow(ResultSet rs,int rowNum) throws SQLException
	   {
		   Invoice invoice=new Invoice();
		   invoice.setInvoiceId(rs.getInt("invoiceId"));
		   invoice.setSupplierId(rs.getInt("supplierId"));
		   invoice.setAmount(rs.getInt("amount"));
		   invoice.setDate(rs.getString("date"));
		   return invoice;
		   
	   }
   }
	@Override
	public void addInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO Invoice (supplierId,amount,date) values (:supplierId,:amount,:date)";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(invoice));
	}

	@Override
	public void updateInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		String sql="UPDATE Invoice set  supplierId= :supplierId,amount=:amount,date=:date where invoiceId=:invoiceId";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(invoice));
		 
	}

	@Override
	public void deleteInvoice(int invoiceId) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM Invoice WHERE invoiceId=:invoiceId";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Invoice(invoiceId)));
		
	}

	@Override
	public Invoice findInvoiceById(int invoiceId) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM Invoice WHERE invoiceId=:invoiceId";
	return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Invoice(invoiceId)),new InvoiceMapper() );
		
	}
	

}
  
