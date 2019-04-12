package com.ttms.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.ttms.service.seatService;

public class findTicketID extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		seatService seat=new seatService();
		
		int scheid=Integer.parseInt(request.getParameter("scheid"));
		
		String[] id=request.getParameter("id").split(",");
	
		
		List<int []> s=new ArrayList<int[]>();
		List<Integer> tickID=new ArrayList<Integer>();
		for(int i=0;i<id.length;i+=2){
			int a[]=new int[2];
			a[0]=Integer.parseInt(id[i]);
			a[1]=Integer.parseInt(id[i+1]);
			s.add(a);
			
		}
		
	
		int num=0;
		for (int[] i:s) {
			
			int a=0;
			try {
				a = seat.findtictet(i[0], i[1], scheid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			tickID.add(a);
			num++;
			
		}
		request.setAttribute("tickID", tickID);
		//鏇存敼session鐨勫墿浣欒喘绁ㄦ鏁�
		
		int ticketnum =(Integer) request.getSession().getAttribute("ticketNumber");
		int i=ticketnum-num;
		
		request.getSession().setAttribute("ticketNumber",i);
		
		
		request.getRequestDispatcher("/lockedticket").forward(request, response);    	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}