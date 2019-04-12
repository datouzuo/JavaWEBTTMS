package com.ttms.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ttms.domain.Studio;
import com.ttms.service.studioService;

public class studio_web extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		studioService studio=new studioService();
		
		//ɾ���ݳ���
		
		//�޸��ݳ���
		
		//��ѯ�ݳ���
		List<Studio> allstu=studio.findallstu();
		//ת��
		request.setAttribute("allstu", allstu);//�����ݳ���
		request.getRequestDispatcher("/studio.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}