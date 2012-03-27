package com.pojo;

import java.io.Serializable;

public class SysUser implements Serializable {

	/**
	 * 此类用于登录和存放登录人的信息，无数据库关联
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String userName;
	private Integer userLevel;       //用来判断,1:学生,2:老师,3:管理员
	private String password;
	public SysUser() {
	}
	public SysUser(Integer id) {
		this.id = id;
	}
	public SysUser(Integer id, String userName, Integer userLevel, String password) {
		this.id = id;
		this.userName = userName;
		this.userLevel = userLevel;
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
