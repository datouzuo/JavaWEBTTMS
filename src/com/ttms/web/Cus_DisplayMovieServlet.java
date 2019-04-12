package com.ttms.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import com.google.gson.Gson;
import com.ttms.domain.play;
import com.ttms.service.Movie_service;

public class Cus_DisplayMovieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Movie_service movie = new Movie_service();
		List<play> movieall = null;
		try {
			movieall =  movie.findall();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Gson json = new Gson();
		String movie1 = json.toJson(movieall);
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(movie1);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}