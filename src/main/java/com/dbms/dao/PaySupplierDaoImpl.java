package com.dbms.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.dbms.model.PaySupplier;

import org.springframework.jdbc.core.RowMapper;
@Repository
public class PaySupplierDaoImpl implements PaySupplierDao{
      NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
{
	this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
}

	 public List listAllPaySupplier() {
		  String sql = "SELECT * FROM PaySupplier";
		  
		  List list = namedParameterJdbcTemplate
		.query(sql, getSqlParameterByModel(null), new PaySupplierMapper());
		  
		  return list;
		 }
   private SqlParameterSource getSqlParameterByModel(PaySupplier paySupplier)
   {
	   MapSqlParameterSource paramSource =new MapSqlParameterSource();
	   if(paySupplier!= null)
	   {
		   paramSource.addValue("paySupplierId", paySupplier.getPaySupplierId());
		   paramSource.addValue("supplierId", paySupplier.getSupplierId());
		   paramSource.addValue("amount", paySupplier.getAmount());
		   paramSource.addValue("date", paySupplier.getDate());
		   
	   }
	   
	   
	   return paramSource;
   }
   private static final class PaySupplierMapper implements RowMapper<PaySupplier>
   {
	   public PaySupplier mapRow(ResultSet rs,int rowNum) throws SQLException
	   {
		   PaySupplier paySupplier=new PaySupplier();
		   paySupplier.setPaySupplierId(rs.getInt("paySupplierId"));
		   paySupplier.setSupplierId(rs.getInt("supplierId"));
		   paySupplier.setAmount(rs.getInt("amount"));
		   paySupplier.setDate(rs.getString("date"));
		   return paySupplier;
		   
	   }
   }
	@Override
	public void addPaySupplier(PaySupplier paySupplier) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO PaySupplier (supplierId,amount,date) values (:supplierId,:amount,:date)";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(paySupplier));
	}

	@Override
	public void updatePaySupplier(PaySupplier paySupplier) {
		// TODO Auto-generated method stub
		String sql="UPDATE PaySupplier set supplierId= :supplierId,amount=:amount,date=:date where paySupplierId=:paySupplierId";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(paySupplier));
		 
	}

	@Override
	public void deletePaySupplier(int paySupplierId) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM PaySupplier WHERE paySupplierId=:paySupplierId";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new PaySupplier(paySupplierId)));
		
	}

	@Override
	public PaySupplier findPaySupplierById(int paySupplierId) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM PaySupplier WHERE paySupplierId=:paySupplierId";
	return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new PaySupplier(paySupplierId)),new PaySupplierMapper() );
		
	}
	

}
  
