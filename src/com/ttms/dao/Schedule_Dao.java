package com.ttms.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import com.ttms.domain.Schedule;
import com.ttms.domain.Studio;
import com.ttms.utils.DataSourceUtils;

public class Schedule_Dao {
//查询演出计划
	public List<Schedule> FindSchedule(String play_id) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from schedule where play_id=?";
		List<Schedule> schedules = runner.query(sql, new BeanListHandler<Schedule>(Schedule.class), play_id);
	    for(Schedule sche : schedules) {
	    	String sql1 = "select * from studio where studio_id=?";
	    	Studio str=  runner.query(sql1, new BeanHandler<Studio>(Studio.class), sche.getStudio_id());
	    	sche.setStudio_name(str.getStudio_name());
	    }
		return schedules;
	}

	public Schedule AddSchedule(Schedule schedule) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql = "insert into schedule(play_id,studio_id,sched_time,sched_ticket_price) value (?,?,?,?)";
		runner.update(sql,schedule.getPlay_id(),schedule.getStudio_id(),schedule.getSched_time(),schedule.getSched_ticket_price());
		String sql1 = "select * from schedule where play_id=? and studio_id=? and sched_time=?";
		Schedule sche =runner.query(sql1, new BeanHandler<Schedule>(Schedule.class), schedule.getPlay_id(),schedule.getStudio_id(),schedule.getSched_time());
		
		return sche;
	}

	public String DeleteSche(String sched_id) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql1="select * from schedule where sched_id=?";
	    Schedule schedule = runner.query(sql1, new BeanHandler<Schedule>(Schedule.class), sched_id);
	    
		String play_id = String.valueOf(schedule.getPlay_id());
		
		String sql = "delete from schedule where sched_id=?";
		runner.update(sql,sched_id);
		return play_id;
	}


}
