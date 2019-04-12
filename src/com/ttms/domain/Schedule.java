package com.ttms.domain;

public class Schedule {
private int sched_id;
private int studio_id;
private String sched_time;
private int play_id;

private int sched_ticket_price;
private String studio_name;


@Override
public String toString() {
	return "Schedule [getPlay_id()=" + getPlay_id() + ", getSched_id()=" + getSched_id() + ", getStudio_id()="
			+ getStudio_id() + ", getSched_time()=" + getSched_time() + ", getStudio_name()=" + getStudio_name()
			+ ", getSched_ticket_price()=" + getSched_ticket_price() + "]";
}
public int getPlay_id() {
	return play_id;
}
public void setPlay_id(int play_id) {
	this.play_id = play_id;
}

public int getSched_id() {
	return sched_id;
}
public void setSched_id(int sched_id) {
	this.sched_id = sched_id;
}
public int getStudio_id() {
	return studio_id;
}
public void setStudio_id(int studio_id) {
	this.studio_id = studio_id;
}

public String getSched_time() {
	return sched_time;
}
public void setSched_time(String sched_time) {
	this.sched_time = sched_time;
}
public String getStudio_name() {
	return studio_name;
}
public void setStudio_name(String studio_name) {
	this.studio_name = studio_name;
}
public int getSched_ticket_price() {
	return sched_ticket_price;
}
public void setSched_ticket_price(int sched_ticket_price) {
	this.sched_ticket_price = sched_ticket_price;
}
}
