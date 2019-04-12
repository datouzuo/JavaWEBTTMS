package com.ttms.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.ttms.domain.Customer;
import com.ttms.idao.Cuseter_idao;
import com.ttms.utils.DataSourceUtils;

public class Cuseter_Dao implements Cuseter_idao{
//	顾客登录
	public Customer cuseter(String usename,String password) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from employee where usename=? and password=?";
		
		Customer customer = runner.query(sql, new BeanHandler<Customer>(Customer.class), usename,password);
		return customer;
	}
//顾客注册
	public int Cus_Sign(Customer p) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into employee (usename,name,"
				+ "email,password,briday,sex)"
				+ "values(?,?,?,?,?,?)";
		int row = runner.update(sql,p.getUsename(),p.getName(),p.getEmail(),p.getPassword(),p.getBriday(),p.getSex());
		
		return row;
	}
	public Customer IfUsername(String username) throws SQLException {
	QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource()); 
	
	String sql = "select * from employee where usename=?";
	Customer row=null;
	row = runner.query(sql, new BeanHandler<Customer>(Customer.class), username);

		return row;
	}

}
