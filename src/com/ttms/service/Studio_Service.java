package com.ttms.service;

import java.sql.SQLException;
import java.util.List;

import com.ttms.dao.Studio_Dao;
import com.ttms.domain.Studio;

public class Studio_Service {

	public List<Studio> FindStudio() throws SQLException {
		Studio_Dao stdio = new Studio_Dao();
		List<Studio> studio = stdio.FindStudio();
		return studio;
	}

}
