package com.ttms.web;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import com.mysql.jdbc.StringUtils;
import com.ttms.domain.PageBean;
import com.ttms.domain.play;
import com.ttms.service.Movie_service;

public class FindMovieAllServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer pa =1;
		
		try {
			String page = request.getParameter("page");
			if(!page.equals("")&&page!=null) {
				pa = Integer.getInteger(page);
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		Movie_service movie = new Movie_service();
		
		
		PageBean listmovie= null;
		try {
			listmovie =  movie.findall(pa);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		request.setAttribute("listmovie", listmovie);
		request.getRequestDispatcher("/display.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}