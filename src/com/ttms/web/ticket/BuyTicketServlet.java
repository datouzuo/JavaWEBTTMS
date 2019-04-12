package com.ttms.web.ticket;

import com.ttms.domain.Ticket;
import com.ttms.service.Ticket_Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BuyTicket", urlPatterns = {"/buyticket"})
public class BuyTicketServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        List<Integer> id = new ArrayList<Integer>();
        List<Ticket> ticekids =  (List<Ticket>) request.getSession().getAttribute("ticket");
       
        
        for(Ticket ticket : ticekids) {
        	id.add(ticket.getTicket_id());
        	
        }
        
HttpSession session = request.getSession();
		
		int num=4;//鐢ㄦ埛鏈�澶氳兘澶熻喘涔板洓寮犵エ
		session.setAttribute("ticketNumber", num);
   /*     
        List<Integer> Ids = new ArrayList<>();
        JSONArray jsonArray = null;
		try {
			jsonArray = new JSONArray(id);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
            
				Ids.add(jsonArray.getInt(i));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }*/
        Ticket_Service ticket_service = new Ticket_Service();
        try {
            ticket_service.BuyTicket(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/TTMS/saleMovieServlet");
        
    }
    
    
    
}
