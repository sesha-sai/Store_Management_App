package com.dbms.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan({"com.dbms.service","com.dbms.dao","com.dbms.model","com.dbms","com.dbms.controller"})
public class DbmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbmsApplication.class, args);
	}

}
