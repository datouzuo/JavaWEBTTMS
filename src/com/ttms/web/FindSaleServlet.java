package com.ttms.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import com.ttms.domain.Sale_item;
import com.ttms.service.Movie_service;

public class FindSaleServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Movie_service sale = new Movie_service();
		List<Sale_item> saleall = null;
		
		try {
			saleall = sale.Findsaleall();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("saleall", saleall);
		/*System.out.println(saleall.get(0).getUsename()+"wodeminzi");*/
		request.getRequestDispatcher("/findsale.jsp").forward(request, response);
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}