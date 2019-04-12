package com.ttms.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.ttms.domain.Schedule;
import com.ttms.domain.Seat;
import com.ttms.domain.Studio;
import com.ttms.domain.Ticket;
import com.ttms.domain.play;
import com.ttms.utils.DataSourceUtils;

public class Ticket_Dao {
	public void Init_Ticket(Schedule schedule) throws SQLException {

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from seat where studio_id=?";
		List<Seat> seatall = runner.query(sql, new BeanListHandler<Seat>(Seat.class), schedule.getStudio_id());
		for (Seat seat : seatall) {
			String sql1 = "insert into ticket(seat_id," + "sched_id,ticket_price,ticket_status,ticket_locked_time) "
					+ "values(?,?,?,?,?)";
			runner.update(sql1, seat.getSeat_id(), schedule.getSched_id(), schedule.getSched_ticket_price(), 0, 0);
		}
	}

	public void Delete_Ticket(String sched_id) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from ticket where sched_id = ?";
		runner.update(sql, sched_id);
	}

	public boolean Refund_ticket(int ticket_id) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from ticket where ticket_id = ?";
		Ticket ticket = null;
		ticket = runner.query(sql, new BeanHandler<Ticket>(Ticket.class), ticket_id);
		if (ticket == null && ticket.getTicket_status() != 9) {
			return false;
		} else {
			sql = "update ticket set ticket_id = 0 where ticket_id = ?";
			runner.update(sql, ticket_id);
		}
		return true;

	}

	public List<Ticket> Get_Ticket(int schedule) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from ticket where sched_id = ?";
		List<Ticket> tickets = runner.query(sql, new BeanListHandler<Ticket>(Ticket.class), schedule);
		return tickets;
	}

	public void SetStatus_Ticket(List<Integer> Ids, int status) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		System.out.println("size = " + Ids.size());
		String sql = "update ticket set ticket_status = ? where ticket_id = ?;";
		for (int i = 0; i < Ids.size(); i++) {
			System.out.println("Id = " + Ids.get(i));
			runner.update(sql, status, Ids.get(i));

		}
	}

	// 閫夊畾搴т綅鍚庢牴鎹骇浣嶇殑id灏嗗骇浣嶉攣瀹氬湪閫夊畾鐘舵��
	public List<Ticket> LockedTicket(List<Integer> Ids, HttpServletRequest request) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = df.format(new Date());
		List<Ticket> tickets = new ArrayList<Ticket>();
		String sql = "select * from ticket where ticket_id = ?";
		/*
		 * 棣栧厛灏嗘墍鏈夐攣瀹氭垚鍔熺殑绁ㄦ壘鍑烘潵杩斿洖缁橲ervlet灞� 鐒跺悗灏嗛攣瀹氱殑绁ㄧ殑淇℃伅浼犻�掔粰瀹氭椂浠诲姟
		 */
		for (int i = 0; i < Ids.size(); i++) {
			Ticket ticket = runner.query(sql, new BeanHandler<Ticket>(Ticket.class), Ids.get(i));
			System.out.println(Ids.get(i) + " " + ticket.getTicket_id());
			if (ticket.getTicket_status() == 0) {
				String sql2 = "update ticket set ticket_locked_time = ?, ticket_status= ? where ticket_id = ?";
				runner.update(sql2, date, 1, Ids.get(i));
				ticket.setTicket_status(1);
				tickets.add(ticket);
			}
		}
		Timer timer = new Timer(); // 寮�濮嬫悶浜嬫儏锛堝紑濮嬪畾鏃朵换鍔★級
		timer.schedule(new Task_Dao(tickets,request), 60000*5);// 900000);
		return tickets;
	}

	public List<Seat> GetSeat(List<Ticket> tickets) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from seat where seat_id = ?";
		List<Seat> seats = new ArrayList<Seat>();
		for (Ticket ticket : tickets) {
			Seat seat = runner.query(sql, new BeanHandler<Seat>(Seat.class), ticket.getSeat_id());
			seats.add(seat);
		}
		return seats;
	}

	public play Getplay(Schedule schedule) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from play where play_id in ( select distinct play_id from schedule where sched_id = ?)";
		play play1 = runner.query(sql, new BeanHandler<play>(play.class), schedule.getSched_id());
		return play1;
	}

	public Studio GetStuName(int studio_id) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select studio_name from studio where studio_id = ?";
		Studio studio = runner.query(sql, new BeanHandler<Studio>(Studio.class), studio_id);
		return studio;
	}

	public Schedule GetSchedule(Ticket ticket) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from schedule where sched_id = ?";
		Schedule schedule = runner.query(sql, new BeanHandler<Schedule>(Schedule.class), ticket.getSched_id());
		return schedule;
	}

	public Boolean BuyTicket(List<Integer> Ids) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = df.format(new Date());
		String sql = "select * from ticket where ticket_id = ?";
		for (int i = 0; i < Ids.size(); i++) {
			System.out.println("one");
			Ticket ticket = runner.query(sql, new BeanHandler<Ticket>(Ticket.class), Ids.get(i));

			if (ticket.getTicket_status() != 1) {
				return false;
			} else {
				String sql2 = "update ticket set ticket_locked_time = ?, ticket_status= ? where ticket_id = ?;";
				runner.update(sql2, date, 9, Ids.get(i));
				System.out.println("three");
			}
		}
		return true;
	}

	public void OutTicket(List<Integer> ticekids) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		
		
		for (int i = 0; i < ticekids.size(); i++) {
		
			
			
				String sql2 = "update ticket set ticket_status= ? where ticket_id = ?;";
				runner.update(sql2,  0, ticekids.get(i));
				
			}
		}
	 
	    }
	    
	

