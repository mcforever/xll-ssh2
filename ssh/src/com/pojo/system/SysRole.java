package com.pojo.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SysRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//--------跟数据库字段对应的属性------------//
	private Integer id;
	private String roleName;
	private String menus;
	private String memo;
	//--------跟数据库字段对应的属性------------//
	
	//--------不跟数据库映射的属性，只用于显示的-----------//
	private List<SysMenu> menuList = new ArrayList<SysMenu>();
	//--------不跟数据库映射的属性，只用于显示的-----------//
	
	public SysRole() {
	}
	

	public SysRole(Integer id, String roleName, String menus, String memo) {
		this.id = id;
		this.roleName = roleName;
		this.menus = menus;
		this.memo = memo;
	}


	public SysRole(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getMenus() {
		return menus;
	}

	public void setMenus(String menus) {
		this.menus = menus;
	}

	public List<SysMenu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<SysMenu> menuList) {
		this.menuList = menuList;
	}
	

}
