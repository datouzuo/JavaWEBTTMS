package com.ttms.web.schedule;

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

public class Play_id_FindSchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Schedule_Service find = new Schedule_Service();
		

		String play_id = request.getParameter("play_id");
		
		List<Schedule> schedules = null;
		try {
			 schedules = find.FindSchedue(play_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Movie_service updata = new Movie_service();
		play movie = null;
		try {
			movie=updata.Movie_updata(play_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("movie", movie);
		request.setAttribute("schedules", schedules);
		request.getRequestDispatcher("/right1.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
