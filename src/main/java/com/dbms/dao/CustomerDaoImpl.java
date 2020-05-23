package com.dbms.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.dbms.model.Customer;

import org.springframework.jdbc.core.RowMapper;
@Repository
public class CustomerDaoImpl implements CustomerDao{
      NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
{
	this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
}

	 public List listAllCustomer() {
		  String sql = "SELECT customerId,name,phoneNo,address FROM Customer";
		  
		  List list = namedParameterJdbcTemplate
		.query(sql, getSqlParameterByModel(null), new CustomerMapper());
		  
		  return list;
		 }
   private SqlParameterSource getSqlParameterByModel(Customer customer)
   {
	   MapSqlParameterSource paramSource =new MapSqlParameterSource();
	   if(customer!= null)
	   {
		   paramSource.addValue("customerId", customer.getCustomerId());
		   paramSource.addValue("name", customer.getName());
		   paramSource.addValue("phoneNo", customer.getPhoneNo());
		   paramSource.addValue("address", customer.getAddress());
		   
	   }
	   
	   
	   return paramSource;
   }
   private static final class CustomerMapper implements RowMapper<Customer>
   {
	   public Customer mapRow(ResultSet rs,int rowNum) throws SQLException
	   {
		   Customer customer=new Customer();
		   customer.setCustomerId(rs.getInt("customerId"));
		   customer.setName(rs.getString("name"));
		   customer.setPhoneNo(rs.getString("phoneNo"));
		   customer.setAddress(rs.getString("address"));
		   return customer;
		   
	   }
   }
	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO Customer (name,phoneNo,address) values (:name,:phoneNo,:address)";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(customer));
	}

	@Override
	public void updateCustomer(Customer Customer) {
		// TODO Auto-generated method stub
		String sql="UPDATE Customer set name= :name,phoneNo=:phoneNo,address=:address where customerId=:customerId";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(Customer));
		 
	}

	@Override
	public void deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM Customer WHERE customerId=:customerId";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Customer(customerId)));
		
	}

	@Override
	public Customer findCustomerById(int customerId) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM Customer WHERE customerId=:customerId";
	return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Customer(customerId)),new CustomerMapper() );
		
	}
	

}
  
