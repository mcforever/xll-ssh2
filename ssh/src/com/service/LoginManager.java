package com.service;

import java.util.List;

import com.pojo.Admin;
import com.pojo.SysUser;
import com.pojo.system.SysMenu;

public interface LoginManager {
	public List<SysMenu> getMenuList();

	public Admin adminLogin(Admin admin);

	public SysUser userLogin(SysUser sysUser);

	public List<SysMenu> querySysMenuList();

	public SysMenu querySysMenuByID(SysMenu bean);
		

}
