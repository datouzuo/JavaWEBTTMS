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
import com.ttms.domain.Ticket;
import com.ttms.domain.play;
import com.ttms.service.Cuser_Service;
import com.ttms.service.Movie_service;
import com.ttms.service.Schedule_Service;
import com.ttms.service.Ticket_Service;

public class DeleteScheServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sched_id = request.getParameter("sched_id");
		Cuser_Service cuser_Service  = new Cuser_Service();
		String play_id = null;
		try {
			play_id = cuser_Service.DeleteSche(sched_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//鍒犻櫎绁�
		Ticket_Service ticket = new Ticket_Service();
		try {
			ticket.DeleteTciket(sched_id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
//鍒犻櫎婕斿嚭鍚庤繘琛屽洖鏄�		
Schedule_Service find = new Schedule_Service();
		
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