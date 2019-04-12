package com.ttms.idao;

import java.sql.SQLException;

import com.ttms.domain.Customer;

public interface Cuseter_idao {

//		顾客登录
		public Customer cuseter(String usename,String password) throws SQLException;
		public int Cus_Sign(Customer p) throws SQLException ;
		public Customer IfUsername(String username) throws SQLException;
	
}
