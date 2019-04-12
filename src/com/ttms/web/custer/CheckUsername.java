package com.ttms.web.custer;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import com.ttms.service.Cuser_Service;

public class CheckUsername extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  request.setCharacterEncoding("UTF-8");
	  String username = request.getParameter("usename");
	  boolean ifuser = false;
	  Cuser_Service cuser_Service = new Cuser_Service();
	  
	  try {
		ifuser = cuser_Service.IfUsername(username);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		

		String json = "{\"isExist\":"+ifuser+"}";
		
		response.getWriter().write(json);	
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}