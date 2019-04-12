package com.ttms.domain;



public class Employee {
	private int access;
	private int id;
	private String name;
	private String password;
	private String cName;
	private String tel;
	
	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getAccess() {
		return access;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void setAccess(int access) {
		this.access = access;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void showValue() {
		System.out.println("编号：" + id + "\t姓名：" + name);
	}

}
