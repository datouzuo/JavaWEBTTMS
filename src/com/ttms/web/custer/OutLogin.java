package com.ttms.web.custer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class OutLogin extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		  
		Cookie cookie_username = new Cookie("usename", null);
		Cookie cookie_password = new Cookie("password", null);
	       
		cookie_password.setMaxAge(0);
		cookie_username.setMaxAge(0);
		
	
		response.addCookie(cookie_password);
		response.addCookie(cookie_username); 
		

		response.sendRedirect("/TTMS/buy_movie.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}