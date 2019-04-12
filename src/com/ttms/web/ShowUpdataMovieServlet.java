package com.ttms.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import com.ttms.domain.Data_dict;
import com.ttms.domain.play;
import com.ttms.service.Movie_service;

public class ShowUpdataMovieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String play_id = request.getParameter("play_id");
		Movie_service updata = new Movie_service();
		play movie = null;
		try {
			movie=updata.Movie_updata(play_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Movie_service showadd = new Movie_service();
		List<Data_dict> movietype = null;
		
		List<Data_dict> movielang = null;
		try {
			movietype = showadd.Movietype();
			movielang = showadd.Movielang();

		} catch (Exception e) {

			e.printStackTrace();
		}
		

		request.setAttribute("movielang", movielang);
		request.setAttribute("movietype", movietype);
		request.setAttribute("movie", movie);
		request.getRequestDispatcher("/updata.jsp").forward(request, response);	
		}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}