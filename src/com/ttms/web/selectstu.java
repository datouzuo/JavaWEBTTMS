package com.ttms.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ttms.domain.Schedule;
import com.ttms.domain.Seat;
import com.ttms.domain.Studio;
import com.ttms.domain.play;
import com.ttms.domain.Schedule;
import com.ttms.domain.Seat;
import com.ttms.domain.Studio;
import com.ttms.service.seatService;

public class selectstu extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		seatService seat=new seatService();
		//��ѯ�ݳ��ƻ�
		
		String AA = (String) request.getAttribute("sched_id");
		int schedID = Integer.valueOf(AA);
		
		
		Schedule sche = seat.find_sch(schedID);
		/*
		 * ��ѯ�ݳ���
		 */
		Studio stu = seat.selectstu(sche.getStudio_id());			
		//��ѯ�ѳ���Ʊ
		ArrayList<Seat> ticket=seat.findseat(schedID);
		
		//��ѯ��Ӱ
		play play=seat.findplay(schedID);
		//ת��
		
		request.setAttribute("play", play);//��Ӱ
		request.setAttribute("scheid", request.getParameter("sched_id"));//�ݳ��ƻ�ID
		request.setAttribute("stu", stu);//�ݳ���
		request.setAttribute("sche", sche);//�ݳ��ƻ�
		request.setAttribute("ticket", ticket);//�ѳ���Ʊ
		request.getRequestDispatcher("/selectSeat.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}