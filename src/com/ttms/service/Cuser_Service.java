package com.ttms.service;


import java.sql.SQLException;

import org.dom4j.DocumentException;

import com.ttms.dao.Cuseter_Dao;
import com.ttms.dao.Schedule_Dao;
import com.ttms.domain.Customer;
import com.ttms.idao.BeanFactory;

import com.ttms.idao.Cuseter_idao;

public class Cuser_Service {

	public Customer cuseter_login(String usename,String password) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, DocumentException {
		Cuseter_idao custer = (Cuseter_idao) BeanFactory.getdao("cuseter_Dao");
		Customer login = custer.cuseter(usename,password);
		
		
		return login;
	}

	

	public boolean Cus_Sign(Customer p) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, DocumentException {
		Cuseter_idao cus = (Cuseter_idao) BeanFactory.getdao("cuseter_Dao");
		int row = cus.Cus_Sign(p);
		boolean r= false;
		if (row>0) {
			r=true;
		}
		return r;
	}

	public String DeleteSche(String sched_id) throws SQLException {
		Schedule_Dao schedule_Dao = new Schedule_Dao();
			String play_id = schedule_Dao.DeleteSche(sched_id);	
			return play_id;
	}

	public boolean IfUsername(String username) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, DocumentException {
		Cuseter_idao custer_Dao = (Cuseter_idao) BeanFactory.getdao("cuseter_Dao");
	   
	   Customer customer = custer_Dao.IfUsername(username);
	   boolean row = false;
	   if (customer!=null) {
		row = true;
	}
		return row;
	}

}
