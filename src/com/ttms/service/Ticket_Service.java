package com.ttms.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ttms.dao.Ticket_Dao;
import com.ttms.domain.Schedule;
import com.ttms.domain.Seat;
import com.ttms.domain.Studio;
import com.ttms.domain.Ticket;
import com.ttms.domain.play;

public class Ticket_Service {

	public void CreatTciket(Schedule sched) throws SQLException {
		Ticket_Dao ticket = new Ticket_Dao();
		ticket.Init_Ticket(sched);
		
	}

	public void DeleteTciket(String sched_id) throws SQLException {
		Ticket_Dao ticket = new Ticket_Dao();
		ticket.Delete_Ticket(sched_id);
		
	}
	
	public Studio GetStuName(int studio_id) throws SQLException {
		Ticket_Dao ticket = new Ticket_Dao();
		return ticket.GetStuName(studio_id);
	}
	
	 public void Init_Ticket(Schedule schedule) throws SQLException {
	        Ticket_Dao ticket_dao = new Ticket_Dao();
	        ticket_dao.Init_Ticket(schedule);
	    }

	    public List<Ticket> Get_Ticket(int schedule) throws SQLException {
	        Ticket_Dao ticket_dao = new Ticket_Dao();
	        List<Ticket> tickets = ticket_dao.Get_Ticket(schedule);
	        return tickets;
	    }

	    public void SetStatus_Ticket(List<Integer> Ids, int status) throws SQLException {
	        Ticket_Dao ticket_dao = new Ticket_Dao();
	        ticket_dao.SetStatus_Ticket(Ids, status);
	    }

	    public List<Ticket> LockedTicket(List<Integer> Ids, HttpServletRequest request) throws SQLException{
	        Ticket_Dao ticket_dao = new Ticket_Dao();
	        return ticket_dao.LockedTicket(Ids,request);
	    }

	    public List<Seat> GetSeat(List<Ticket> tickets) throws SQLException {
	        Ticket_Dao ticket_dao = new Ticket_Dao();
	        return ticket_dao.GetSeat(tickets);
	    }
	    
	    public Schedule GetSchedule(Ticket ticket) throws SQLException{
	    	Ticket_Dao ticket_dao = new Ticket_Dao();
	    	return ticket_dao.GetSchedule(ticket);
	    }

	    public play Getplay(Schedule schedule) throws SQLException {
	        Ticket_Dao ticket_dao = new Ticket_Dao();
	        return ticket_dao.Getplay(schedule);
	    }
	    public Boolean BuyTicket(List<Integer> Ids)throws SQLException{
	        Ticket_Dao ticket_dao = new Ticket_Dao();
	        return ticket_dao.BuyTicket(Ids);
	    }

		public void OutTicket(List<Integer> ticekids) throws SQLException {
			Ticket_Dao ticket_Dao = new Ticket_Dao();
			ticket_Dao.OutTicket(ticekids);
			
		}
	
	
	
	
	
	
	
	
	
}
