package com.ttms.web.ticket;

import com.ttms.domain.Schedule;
import com.ttms.domain.Seat;
import com.ttms.domain.Studio;
import com.ttms.domain.Ticket;
import com.ttms.domain.play;
import com.ttms.service.Ticket_Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.coyote.Request;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LockedTicket", urlPatterns = { "/lockedticket" })
public class LockedTicketServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		List<Integer> id = (List<Integer>) request.getAttribute("tickID");
		

		Ticket_Service ticket_service = new Ticket_Service();
		List<Ticket> tickets = null;
		try {

			tickets = ticket_service.LockedTicket(id,request);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (tickets.isEmpty()) {
			try {
				ticket_service.SetStatus_Ticket(id, 0);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("/TTMS/buy_movie.jsp");
		} else {
			List<Seat> seats = null;
			try {
				seats = ticket_service.GetSeat(tickets);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			Schedule schedule = null;
			try {
				schedule = ticket_service.GetSchedule(tickets.get(0));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			play play1 = null;
				try {
					play1 = ticket_service.Getplay(schedule);
				} catch (SQLException e) {
					e.printStackTrace();
				}

				Studio studio = null;
				try {
					studio = ticket_service.GetStuName(schedule.getStudio_id());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int i = 0;
				for (Ticket ticket : tickets) {
					i++;
				}

				HttpSession session = request.getSession();

				int sale = i * play1.getPlay_ticket_price();
				
				request.setAttribute("ticket", tickets);

				request.setAttribute("seat", seats);

				request.setAttribute("schedule", schedule);

				request.setAttribute("play", play1);

				request.setAttribute("sale", sale);
			
			request.getRequestDispatcher("/FinallySale.jsp").forward(request, response);
		}
	} 
	
}
