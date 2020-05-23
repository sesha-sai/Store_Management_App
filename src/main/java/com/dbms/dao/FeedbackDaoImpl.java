package com.dbms.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.dbms.model.Feedback;

import org.springframework.jdbc.core.RowMapper;
@Repository
public class FeedbackDaoImpl implements FeedbackDao{
      NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
{
	this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
}

	 public List listAllFeedback() {
		  String sql = "SELECT feedbackId,customerId,remarks,date FROM Feedback";
		  
		  List list = namedParameterJdbcTemplate
		.query(sql, getSqlParameterByModel(null), new FeedbackMapper());
		  
		  return list;
		 }
   private SqlParameterSource getSqlParameterByModel(Feedback feedback)
   {
	   MapSqlParameterSource paramSource =new MapSqlParameterSource();
	   if(feedback!= null)
	   {
		   paramSource.addValue("feedbackId", feedback.getFeedbackId());
		   paramSource.addValue("customerId", feedback.getCustomerId());
		   paramSource.addValue("remarks", feedback.getRemarks());
		   paramSource.addValue("date", feedback.getDate());
		   
	   }
	   
	   
	   return paramSource;
   }
   private static final class FeedbackMapper implements RowMapper<Feedback>
   {
	   public Feedback mapRow(ResultSet rs,int rowNum) throws SQLException
	   {
		   Feedback feedback=new Feedback();
		   feedback.setFeedbackId(rs.getInt("feedbackId"));
		   feedback.setCustomerId(rs.getInt("customerId"));
		   feedback.setRemarks(rs.getString("remarks"));
		   feedback.setDate(rs.getString("date"));
		   return feedback;
		   
	   }
   }
	@Override
	public void addFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO Feedback (customerId,remarks,date) values (:customerId,:remarks,:date)";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(feedback));
	}

	@Override
	public void updateFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		String sql="UPDATE Feedback set customerId= :customerId,remarks=:remarks,date=:date where feedbackId=:feedbackId";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(feedback));
		 
	}

	@Override
	public void deleteFeedback(int feedbackId) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM Feedback WHERE feedbackId=:feedbackId";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Feedback(feedbackId)));
		
	}

	@Override
	public Feedback findFeedbackById(int feedbackId) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM Feedback WHERE feedbackId=:feedbackId";
	return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Feedback(feedbackId)),new FeedbackMapper() );
		
	}
	

}
  
