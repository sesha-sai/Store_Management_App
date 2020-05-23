package com.dbms.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.dbms.model.Wage;

import org.springframework.jdbc.core.RowMapper;
@Repository
public class WageDaoImpl implements WageDao{
      NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
{
	this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
}

	 public List listAllWage() {
		  String sql = "SELECT * FROM Wage";
		  
		  List list = namedParameterJdbcTemplate
		.query(sql, getSqlParameterByModel(null), new WageMapper());
		  
		  return list;
		 }
   private SqlParameterSource getSqlParameterByModel(Wage wage)
   {
	   MapSqlParameterSource paramSource =new MapSqlParameterSource();
	   if(wage!= null)
	   {
		   paramSource.addValue("wageId", wage.getWageId());
		   paramSource.addValue("employeeId", wage.getEmployeeId());
		   paramSource.addValue("amount", wage.getAmount());
		   paramSource.addValue("date", wage.getDate());
		   
	   }
	   
	   
	   return paramSource;
   }
   private static final class WageMapper implements RowMapper<Wage>
   {
	   public Wage mapRow(ResultSet rs,int rowNum) throws SQLException
	   {
		   Wage wage=new Wage();
		   wage.setWageId(rs.getInt("wageId"));
		   wage.setEmployeeId(rs.getInt("employeeId"));
		   wage.setAmount(rs.getInt("amount"));
		   wage.setDate(rs.getString("date"));
		   return wage;
		   
	   }
   }
	@Override
	public void addWage(Wage wage) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO Wage (employeeId,amount,date) values (:employeeId,:amount,:date)";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(wage));
	}

	@Override
	public void updateWage(Wage wage) {
		// TODO Auto-generated method stub
		String sql="UPDATE Wage set employeeId= :employeeId,amount=:amount,date=:date where wageId=:wageId";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(wage));
		 
	}

	@Override
	public void deleteWage(int wageId) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM Wage WHERE wageId=:wageId";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Wage(wageId)));
		
	}

	@Override
	public Wage findWageById(int wageId) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM Wage WHERE wageId=:wageId";
	return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Wage(wageId)),new WageMapper() );
		
	}
	

}
  
