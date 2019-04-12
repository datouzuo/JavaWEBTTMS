package com.ttms.domain;

public class Seat {

private int seat_id;
private int studio_id;
private int seat_row;
private int seat_column;


@Override
public String toString() {
	return "Seat [getSeat_id()=" + getSeat_id() + ", getStudio_id()=" + getStudio_id() + ", getSeat_row()="
			+ getSeat_row() + ", getSeat_column()=" + getSeat_column() + "]";
}

public int getSeat_id() {
	return seat_id;
}

public void setSeat_id(int seat_id) {
	this.seat_id = seat_id;
}
public int getStudio_id() {
	return studio_id;
}
public void setStudio_id(int studio_id) {
	this.studio_id = studio_id;
}
public int getSeat_row() {
	return seat_row;
}
public void setSeat_row(int seat_row) {
	this.seat_row = seat_row;
}
public int getSeat_column() {
	return seat_column;
}
public void setSeat_column(int seat_column) {
	this.seat_column = seat_column;
}
}
