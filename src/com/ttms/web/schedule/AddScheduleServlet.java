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
import com.ttms.service.Ticket_Service;

public class AddScheduleServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String play_id = request.getParameter("play_id");
	String  studio_id = request.getParameter("studio_id");
	String  time1 = request.getParameter("time1");
	String  time2 = request.getParameter("time2");
	String time = time1+" "+time2;
	
	Movie_service updata = new Movie_service();
	play movie = null;
	try {
		movie=updata.Movie_updata(play_id);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	Schedule schedule = new Schedule();
	schedule.setPlay_id(Integer.valueOf(play_id));
	schedule.setStudio_id(Integer.valueOf(studio_id));
	schedule.setSched_ticket_price(movie.getPlay_ticket_price());
	schedule.setSched_time(time);
	Schedule_Service schedule_Service = new Schedule_Service();
	Schedule sched = null;
	try {
		sched = schedule_Service.AddSchedule(schedule);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

	
	}
	//鐢熸垚绁�
	System.out.println(sched.getSched_id());
	Ticket_Service ticket = new Ticket_Service();

	try {
		ticket.CreatTciket(sched);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	
	
	Schedule_Service find = new Schedule_Service();
	List<Schedule> schedules = null;
	try {
		 schedules = find.FindSchedue(play_id);
	} catch (SQLException e) {
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