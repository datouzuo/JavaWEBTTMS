package com.ttms.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import com.ttms.domain.Schedule;
import com.ttms.domain.play;
import com.ttms.service.Movie_service;
import com.ttms.service.Schedule_Service;

public class Buy_DisplayMovieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String play_id = request.getParameter("play_id");
		
		
		Movie_service mm = new Movie_service();
		play movie = null;
	    try {
			movie = mm.FindOne(play_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Schedule_Service find = new Schedule_Service();
		//
		List<Schedule> schedules = null;
		try {
			 schedules = find.FindSchedue(play_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(movie.getPlay_name());
		request.setAttribute("schedules", schedules);
		request.setAttribute("movie", movie);
		request.getRequestDispatcher("/buy_movie.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}