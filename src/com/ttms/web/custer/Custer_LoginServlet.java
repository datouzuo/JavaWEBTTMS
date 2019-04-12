package com.ttms.web.custer;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.dom4j.DocumentException;
import com.ttms.domain.Customer;
import com.ttms.service.Cuser_Service;
import com.ttms.utils.CheckImage;

public class Custer_LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String checkimg = request.getParameter("checkimg");
		
	if (!checkimg.equals(CheckImage.getValidateCode(request))) {

		request.setAttribute("error", "楠岃瘉鐮侀敊璇�,鍖哄垎澶у皬鍐欏摝锛屼翰");
		request.getRequestDispatcher("/Custer_Login.jsp").forward(request, response);
		} 
	
	else if (checkimg.equals(CheckImage.getValidateCode(request)))
	
	{

			String usename = request.getParameter("usename");
			String password = request.getParameter("password");
			String object = request.getParameter("object");
			Cuser_Service cuseter = new Cuser_Service();

			Customer login = null;
			try {
				login = cuseter.cuseter_login(usename, password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (login != null) {
				HttpSession session = request.getSession();
				
				int num=4;//鐢ㄦ埛鏈�澶氳兘澶熻喘涔板洓寮犵エ
				session.setAttribute("ticketNumber", num);
				
				
				session.setAttribute("user", login);
				System.out.println(request.getSession().getAttribute("user"));
				if (object != null) {
					String use = URLEncoder.encode(usename, "UTF-8");
					Cookie cookie_usename = new Cookie("usename", use);
					Cookie cookie_password = new Cookie("password", password);
					cookie_password.setMaxAge(60 * 60 * 60);
					cookie_usename.setMaxAge(60 * 60 * 60);
					response.addCookie(cookie_password);
					response.addCookie(cookie_usename);
				} else {
					Cookie[] cookies = request.getCookies();

					if (cookies != null) {
						for (Cookie cookie : cookies) {
							cookie.setMaxAge(0);
							cookie.setPath("/");
							response.addCookie(cookie);
						}
					}
				}

				response.sendRedirect(request.getContextPath() + "/buy_movie.jsp");
			} else {

				request.setAttribute("error", "瀵嗙爜鎴栫敤鎴峰嚭閿�");
				request.getRequestDispatcher("/Custer_Login.jsp").forward(request, response);
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}