package com.ttms.domain;

public class Ticket {
	
	private int ticket_id;
	private int seat_id;
     @Override
	public String toString() {
		return "Ticket [getTicket_status()=" + getTicket_status() + ", getSched_id()=" + getSched_id()
				+ ", getTicket_id()=" + getTicket_id() + ", getSeat_id()=" + getSeat_id() + ", getStdio_id()="
				+ getStdio_id() + ", getTicket_locked_time()=" + getTicket_locked_time() + ", getTicket_price()="
				+ getTicket_price() + "]";
	}
	private int stdio_id;
	private String ticket_locked_time;
	private int ticket_price;
	private int sched_id;
	private int ticket_status;
	
	public int getTicket_status() {
		return ticket_status;
	}
	public void setTicket_status(int ticket_status) {
		this.ticket_status = ticket_status;
	}
	public int getSched_id() {
		return sched_id;
	}
	public void setSched_id(int sched_id) {
		this.sched_id = sched_id;
	}
	public int getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}


	public int getSeat_id() {
		return seat_id;
	}
	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
	}
	public int getStdio_id() {
		return stdio_id;
	}
	public void setStdio_id(int stdio_id) {
		this.stdio_id = stdio_id;
	}
	public String getTicket_locked_time() {
		return ticket_locked_time;
	}
	public void setTicket_locked_time(String ticket_locked_time) {
		this.ticket_locked_time = ticket_locked_time;
	}
	public int getTicket_price() {
		return ticket_price;
	}
	public void setTicket_price(int ticket_price) {
		this.ticket_price = ticket_price;
	}
	
	
}
