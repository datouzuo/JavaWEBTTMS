package com.ttms.web.custer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ttms.domain.Customer;



public class IfLogin extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sched_id = request.getParameter("sched_id");
	
		Customer usr = (Customer) session.getAttribute("user");
		if (usr==null) {
			response.sendRedirect("/TTMS/Custer_Login.jsp");
		}
			else {
				
				request.setAttribute("sched_id", sched_id);
				System.out.println(sched_id);
				
				request.getRequestDispatcher("/selectstuServlet").forward(request, response);
			}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}