package com.ttms.service;

import java.sql.SQLException;
import java.util.List;

import com.ttms.dao.Seat_Dao;
import com.ttms.dao.Studio_Dao;
import com.ttms.domain.Studio;

public class studioService {

	public void addstu(String name, int row_Count, int col_Count, String introduction) throws SQLException {
		Studio s = new Studio();
		s.setStudio_name(name);
		s.setStudio_row_Count(row_Count);
		s.setStudio_col_Count(col_Count);
		s.setStudio_introduction(introduction);
		Studio_Dao addstu = new Studio_Dao();
		addstu.addstu(s);
		Studio studio = addstu.FindStudio_ID(s);
		
		Seat_Dao seat =new Seat_Dao();
		seat.CreatSeat(studio);
		
		
	}

	// ɾ���ݳ���
	public void delstu(int id) throws SQLException {
		Studio_Dao delstu = new Studio_Dao();
		delstu.delstu(id);
		Seat_Dao seat =new Seat_Dao();
		seat.DeleteSeat(id);
	}

	// �޸��ݳ���
//	public void modstu(String name, int row_Count, int col_Count, String introduction, int Studio_id) {
//		Studio s = new Studio();
//		s.setStudio_name(name);
//		s.setStudio_row_Count(row_Count);
//		s.setStudio_col_Count(col_Count);
//		s.setStudio_introduction(introduction);
//		s.setStudio_id(Studio_id);
//		Studio_Dao modstu = new Studio_Dao();
//		
//		modstu.modstu(s);
//	
//	}

	/**
	 * ��ѯ�����ݳ���
	 */
	public List<Studio> findallstu() {
		Studio_Dao sd = new Studio_Dao();
		List<Studio> stu = sd.findallstu();
		return stu;
	}
}
