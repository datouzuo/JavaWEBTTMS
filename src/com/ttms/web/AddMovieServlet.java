package com.ttms.web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ttms.domain.play;
import com.ttms.service.Movie_service;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.dom4j.DocumentException;

public class AddMovieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		play py = new play();
		Map<String, Object> map = new HashMap<String, Object>();

		DiskFileItemFactory fileItemFactor = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactor);

		try {
			List<FileItem> pareruqust = upload.parseRequest(request);

			for (FileItem Item : pareruqust) {
				boolean formField = Item.isFormField();
				if (formField) {
					String fileidname = Item.getFieldName();
					String filevalue = Item.getString("UTF-8");
					System.out.println(fileidname);
					map.put(fileidname, filevalue);

				} else {

					String filename = Item.getName();
					String path = this.getServletContext().getRealPath("img");

					InputStream in = Item.getInputStream();
					OutputStream out = new FileOutputStream(path + "/" + filename);
					IOUtils.copy(in, out);
					in.close();
					out.close();

					py.setplay_image("img/" + filename);
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			BeanUtils.populate(py, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		py.setPlay_status(1);
		System.out.println(py.getPlay_name());

		Movie_service movie = new Movie_service();
		try {
			movie.addmovie(py);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect(request.getContextPath() + "/findMovieAllServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
