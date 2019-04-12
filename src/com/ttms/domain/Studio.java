package com.ttms.domain;


public class Studio {
	private int studio_id   ; 
	private String studio_name ;
	private int studio_row_Count;
	private int studio_col_Count;
	private String studio_introduction; //���
	public int getStudio_id() {
		return studio_id;
	}
	public void setStudio_id(int studio_id) {
		this.studio_id = studio_id;
	}
	public String getStudio_name() {
		return studio_name;
	}
	public void setStudio_name(String studio_name) {
		this.studio_name = studio_name;
	}
	public int getStudio_row_Count() {
		return studio_row_Count;
	}
	public void setStudio_row_Count(int studio_row_Count) {
		this.studio_row_Count = studio_row_Count;
	}
	public int getStudio_col_Count() {
		return studio_col_Count;
	}
	public void setStudio_col_Count(int studio_col_Count) {
		this.studio_col_Count = studio_col_Count;
	}
	public String getStudio_introduction() {
		return studio_introduction;
	}
	public void setStudio_introduction(String studio_introduction) {
		this.studio_introduction = studio_introduction;
	}
	

}
