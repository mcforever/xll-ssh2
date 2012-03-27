package com.pojo;

import java.io.Serializable;

public class Admin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//--------跟数据库字段对应的属性------------//
	private Integer id;
	private String adminName;
	private String password;
	private String memo;
	//--------跟数据库字段对应的属性------------//
	
	//--------不跟数据库映射的属性，只用于显示的-----------//
	
	//--------不跟数据库映射的属性，只用于显示的-----------//
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	

}
