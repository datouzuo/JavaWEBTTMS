package com.ttms.domain;

public class Sale_item {
	private int sale_item_id;
	private int ticket_id;
	private int emp_id;
	private String sale_time;
	private String usename;
	private String play_name;
	public String getUsename() {
		return usename;
	}
	public void setUsename(String usename) {
		this.usename = usename;
	}
	public String getPlay_name() {
		return play_name;
	}
	public void setPlay_name(String play_name) {
		this.play_name = play_name;
	}
	public int getSale_item_id() {
		return sale_item_id;
	}
	public void setSale_item_id(int sale_item_id) {
		this.sale_item_id = sale_item_id;
	}
	public int getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getSale_time() {
		return sale_time;
	}
	public void setSale_time(String sale_time) {
		this.sale_time = sale_time;
	}

}
