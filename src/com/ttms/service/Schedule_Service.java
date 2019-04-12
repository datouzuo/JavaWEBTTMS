package com.ttms.service;

import java.sql.SQLException;
import java.util.List;

import com.ttms.dao.Schedule_Dao;
import com.ttms.domain.Schedule;

public class Schedule_Service {

	public List<Schedule> FindSchedue(String play_id) throws SQLException {
		Schedule_Dao sche = new Schedule_Dao();
		List<Schedule> schedules = sche.FindSchedule(play_id);
		return schedules;
	}

	public Schedule AddSchedule(Schedule schedule) throws SQLException {
		Schedule_Dao dao = new Schedule_Dao();
		Schedule sched = dao.AddSchedule(schedule);
		return sched;
	}



}
