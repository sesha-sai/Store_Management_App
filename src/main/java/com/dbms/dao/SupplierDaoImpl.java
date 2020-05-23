package com.dbms.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.dbms.model.Supplier;

import org.springframework.jdbc.core.RowMapper;
@Repository
public class SupplierDaoImpl implements SupplierDao{
      NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
{
	this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
}

	 public List listAllSupplier() {
		  String sql = "SELECT * FROM Supplier";
		  
		  List list = namedParameterJdbcTemplate
		.query(sql, getSqlParameterByModel(null), new SupplierMapper());
		  
		  return list;
		 }
   private SqlParameterSource getSqlParameterByModel(Supplier supplier)
   {
	   MapSqlParameterSource paramSource =new MapSqlParameterSource();
	   if(supplier!= null)
	   {
		   paramSource.addValue("supplierId", supplier.getSupplierId());
		   paramSource.addValue("name", supplier.getName());
		   paramSource.addValue("amount", supplier.getAmount());
		   paramSource.addValue("address", supplier.getAddress());
		   
	   }
	   
	   
	   return paramSource;
   }
   private static final class SupplierMapper implements RowMapper<Supplier>
   {
	   public Supplier mapRow(ResultSet rs,int rowNum) throws SQLException
	   {
		   Supplier supplier=new Supplier();
		   supplier.setSupplierId(rs.getInt("supplierId"));
		   supplier.setName(rs.getString("name"));
		   supplier.setAmount(rs.getInt("amount"));
		   supplier.setAddress(rs.getString("address"));
		   return supplier;
		   
	   }
   }
	@Override
	public void addSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO Supplier (name,amount,address) values (:name,:amount,:address)";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(supplier));
	}

	@Override
	public void updateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		String sql="UPDATE Supplier set name=:name amount= :amount,address=:address where supplierId=:supplierId";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(supplier));
		 
	}

	@Override
	public void deleteSupplier(int supplierId) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM Supplier WHERE supplierId=:supplierId";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Supplier(supplierId)));
		
	}

	@Override
	public Supplier findSupplierById(int supplierId) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM Supplier WHERE supplierId=:supplierId";
	return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Supplier(supplierId)),new SupplierMapper() );
		
	}
	

}
  
