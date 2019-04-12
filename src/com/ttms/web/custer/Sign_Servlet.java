package com.ttms.web.custer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.dom4j.DocumentException;

import com.ttms.domain.Customer;
import com.ttms.domain.play;
import com.ttms.service.Cuser_Service;
import com.ttms.utils.CheckImage;

public class Sign_Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String checkimg = request.getParameter("checkimg");
		if (!checkimg.equals(CheckImage.getValidateCode(request))) {

			request.setAttribute("error", "验证码错误，注意区分大小写哦");
			request.getRequestDispatcher("/cus_sign.jsp").forward(request, response);
		} 
		
		if (checkimg.equals(CheckImage.getValidateCode(request)))
		
		{
		
		
		
		request.setCharacterEncoding("UTF-8");
		Map<String, String[]> pMap = request.getParameterMap();
		Customer p = new Customer();
		try {
			BeanUtils.populate(p, pMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Cuser_Service cuser = new Cuser_Service();
		try {
			boolean b = cuser.Cus_Sign(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/Custer_Login.jsp");
	}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
