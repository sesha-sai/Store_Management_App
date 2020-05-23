package com.dbms.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.dbms.model.Employee;

import org.springframework.jdbc.core.RowMapper;
@Repository
public class EmployeeDaoImpl implements EmployeeDao{
      NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
{
	this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
}

	 public List listAllEmployee() {
		  String sql = "SELECT employeeId,name,phoneNo,address,monthlyWage FROM Employee";
		  
		  List list = namedParameterJdbcTemplate
		.query(sql, getSqlParameterByModel(null), new EmployeeMapper());
		  
		  return list;
		 }
   private SqlParameterSource getSqlParameterByModel(Employee employee)
   {
	   MapSqlParameterSource paramSource =new MapSqlParameterSource();
	   if(employee!= null)
	   {
		   paramSource.addValue("employeeId", employee.getEmployeeId());
		   paramSource.addValue("name", employee.getName());
		   paramSource.addValue("phoneNo", employee.getPhoneNo());
		   paramSource.addValue("address", employee.getAddress());
		   paramSource.addValue("monthlyWage", employee.getMonthlyWage());
		   
	   }
	   
	   
	   return paramSource;
   }
   private static final class EmployeeMapper implements RowMapper<Employee>
   {
	   public Employee mapRow(ResultSet rs,int rowNum) throws SQLException
	   {
		   Employee employee=new Employee();
		   employee.setEmployeeId(rs.getInt("employeeId"));
		   employee.setName(rs.getString("name"));
		   employee.setPhoneNo(rs.getString("phoneNo"));
		   employee.setAddress(rs.getString("address"));
		   employee.setMonthlyWage(rs.getInt("monthlyWage"));
		   return employee;
		   
	   }
   }
	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO Employee (name,phoneNo,address,monthlyWage) values (:name,:phoneNo,:address,:monthlyWage)";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(employee));
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		String sql="UPDATE Employee set name=:name phoneNo= :phoneNo,address=:address,monthlyWage=:monthlyWage where employeeId=:employeeId";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(employee));
		 
	}

	@Override
	public void deleteEmployee(int employeeId) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM Employee WHERE employeeId=:employeeId";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Employee(employeeId)));
		
	}

	@Override
	public Employee findEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM Employee WHERE employeeId=:employeeId";
	return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Employee(employeeId)),new EmployeeMapper() );
		
	}
	

}
  
