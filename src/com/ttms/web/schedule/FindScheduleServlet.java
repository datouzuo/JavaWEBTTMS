package com.ttms.web.schedule;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ttms.domain.Studio;
import com.ttms.service.Schedule_Service;
import com.ttms.service.Studio_Service;

public class FindScheduleServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Studio_Service stu = new Studio_Service();
		List<Studio> studios = null;
		try {
		studios = stu.FindStudio();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson json = new Gson();
		String string = json.toJson(studios);
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(string);
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}