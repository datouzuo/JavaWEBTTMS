package com.ttms.domain;

public class Data_dict {
	
	private int dict_id;
	private int dict_parent_id;
	private int dict_index;
	private String dict_name;
	private String  dict_value;
	public int getDict_id() {
		return dict_id;
	}
	public void setDict_id(int dict_id) {
		this.dict_id = dict_id;
	}
	public int getDict_parent_id() {
		return dict_parent_id;
	}
	public void setDict_parent_id(int dict_parent_id) {
		this.dict_parent_id = dict_parent_id;
	}
	public int getDict_index() {
		return dict_index;
	}
	public void setDict_index(int dict_index) {
		this.dict_index = dict_index;
	}
	public String getDict_name() {
		return dict_name;
	}
	public void setDict_name(String dict_name) {
		this.dict_name = dict_name;
	}
	public String getDict_value() {
		return dict_value;
	}
	public void setDict_value(String dict_value) {
		this.dict_value = dict_value;
	}
	
	/*create table data_dict
	(
	   dict_id              int not null auto_increment,
	   dict_parent_id       int,
	   dict_index           int,
	   dict_name            varchar(200),
	   dict_value           varchar(100) not null,
	   primary key (dict_id)
	);
*/
}
