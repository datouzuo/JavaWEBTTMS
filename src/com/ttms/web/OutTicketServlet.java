package com.ttms.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ttms.domain.Ticket;
import com.ttms.service.Ticket_Service;

public class OutTicketServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    HttpSession session = request.getSession();
	    session.removeAttribute("ticketNumber");
	    int num=4;//鐢ㄦ埛鏈�澶氳兘澶熻喘涔板洓寮犵エ
	    	session.setAttribute("ticketNumber", num);
	    	
	    	   request.setCharacterEncoding("UTF-8");
	           List<Integer> id = new ArrayList<Integer>();
	           List<Ticket> ticekids =  (List<Ticket>) request.getSession().getAttribute("ticket");
	          if (ticekids!=null) {
			
	           for(Ticket ticket : ticekids) {
	           	id.add(ticket.getTicket_id());
	           	
	           }
	           
	           Ticket_Service ticket_Service = new Ticket_Service();
	           try {
				ticket_Service.OutTicket(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	           response.sendRedirect("/TTMS/buy_movie.jsp");
	    	
	    	
	}else {
	    	
	    	
	    	
	    	response.sendRedirect("/TTMS/buy_movie.jsp");}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
