package com.dbms.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.dbms.model.Brand;

import org.springframework.jdbc.core.RowMapper;
@Repository
public class BrandDaoImpl implements BrandDao{
      NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
{
	this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
}

	 public List listAllBrand() {
		  String sql = "SELECT brandId,name,since FROM Brand";
		  
		  List list = namedParameterJdbcTemplate
		.query(sql, getSqlParameterByModel(null), new BrandMapper());
		  
		  return list;
		 }
   private SqlParameterSource getSqlParameterByModel(Brand brand)
   {
	   MapSqlParameterSource paramSource =new MapSqlParameterSource();
	   if(brand!= null)
	   {
		   paramSource.addValue("brandId", brand.getBrandId());
		   paramSource.addValue("name", brand.getName());
		   paramSource.addValue("since", brand.getSince());
		  
		   
	   }
	   
	   
	   return paramSource;
   }
   private static final class BrandMapper implements RowMapper<Brand>
   {
	   public Brand mapRow(ResultSet rs,int rowNum) throws SQLException
	   {
		   Brand brand=new Brand();
		   brand.setBrandId(rs.getInt("brandId"));
		   brand.setName(rs.getString("name"));
		   brand.setSince(rs.getString("since"));

		   return brand;
		   
	   }
   }
	@Override
	public void addBrand(Brand brand) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO Brand (name,since) values (:name,:since)";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(brand));
	}

	@Override
	public void updateBrand(Brand Brand) {
		// TODO Auto-generated method stub
		String sql="UPDATE Brand set name= :name,since=:since where brandId=:brandId";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(Brand));
		 
	}

	@Override
	public void deleteBrand(int brandId) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM Brand WHERE brandId=:brandId";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Brand(brandId)));
		
	}

	@Override
	public Brand findBrandById(int brandId) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM Brand WHERE brandId=:brandId";
	return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Brand(brandId)),new BrandMapper() );
		
	}
	

}
  
