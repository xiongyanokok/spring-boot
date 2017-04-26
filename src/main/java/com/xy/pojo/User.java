package com.xy.pojo;

public class User {

	private String name;
	private String pwd;
	private String xxx;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getXxx() {
		return xxx;
	}
	public void setXxx(String xxx) {
		this.xxx = xxx;
	}

	@Override
	public String toString() {
		return "name=" + name + " pwd=" + pwd + " xxx=" + xxx;
	}

}
