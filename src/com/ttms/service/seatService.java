package com.ttms.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ttms.dao.Seat_Dao;
import com.ttms.domain.Schedule;
import com.ttms.domain.Seat;
import com.ttms.domain.Studio;
import com.ttms.domain.play;



public class seatService {
	/**
	 * ѡ���ݳ���
	 * @param Studio_id
	 * @return
	 */
	public Studio selectstu(int Studio_id){
		Seat_Dao sd=new Seat_Dao();
		Studio stu = sd.findstu(Studio_id);//��ѯ�ݳ���
		//sd.addseat(stu);//�����λ
		return stu;
	}
	/**
	 * ��ѯ�ݳ��ƻ�
	 * @param schedule_id
	 * @return
	 */
	public Schedule find_sch(int schedule_id){
		Seat_Dao sd=new Seat_Dao();
		Schedule stu = sd.findSchedule(schedule_id);
		return stu;
	}
	
	/**
	 * ��ѯ�ѳ���Ʊ
	 * @param schedule_id
	 * @return
	 */
	public ArrayList<Seat> findseat(int schedule_id){
		Seat_Dao sd=new Seat_Dao();
		ArrayList<Seat> seat = sd.findSeat(schedule_id);
		return seat;
	}
	/**
	 * ��ѯƱid
	 * @param row
	 * @param col
	 * @param scheID
	 * @return
	 * @throws SQLException 
	 */
	public int findtictet(int row,int col,int scheID) throws SQLException{
		Seat_Dao sd=new Seat_Dao();
		
		int id = sd.findticketID(row, col, scheID);
		return id;
	}	
	
	public play findplay(int id){
		Seat_Dao sd=new Seat_Dao();
		play ID = sd.findplay(id);
		return ID;
	}	
}
