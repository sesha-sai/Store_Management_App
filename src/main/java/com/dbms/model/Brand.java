package com.dbms.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Brand {
	@Id
	private Integer brandId;
	 private String name;
	 private String since;
	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Brand(Integer brandId) {
		super();
		this.brandId = brandId;
	}
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSince() {
		return since;
	}
	public void setSince(String since) {
		this.since = since;
	}
	
	 
}
