package com.ttms.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import com.ttms.dao.Movie_Dao;
import com.ttms.service.Movie_service;

public class AddTypeLangServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String dict_lang = null;
		String dict_type = null;
		dict_lang = request.getParameter("dict_lang");
		dict_type = request.getParameter("dict_type");
		
		try {
			if (dict_type!=null) {
				Movie_service movietype = new Movie_service();

				movietype.Addtype(dict_type);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			if (dict_lang!=null) {
				Movie_service movielang = new Movie_service();

				movielang.Addlang(dict_lang);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect(request.getContextPath() + "/addMovieServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}