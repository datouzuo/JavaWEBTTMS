package com.ttms.web;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dom4j.DocumentException;

import com.ttms.domain.Customer;
import com.ttms.domain.Ticket;
import com.ttms.service.Movie_service;



public class SaleMovieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	   Customer user = (Customer)  request.getSession().getAttribute("user");
	   List<Ticket> ticekids =  (List<Ticket>) request.getSession().getAttribute("ticket");
	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	   String date = format.format(new Date());
	   Movie_service sale = new Movie_service();
	  
	   try {
		sale.SaleMovie(user,ticekids,date);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   request.getSession().getAttribute("ticket");
	   response.sendRedirect("/TTMS/finallycus.jsp");
	   
	   
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
