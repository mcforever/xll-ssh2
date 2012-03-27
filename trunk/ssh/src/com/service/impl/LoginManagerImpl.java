package com.service.impl;

import java.util.List;

import com.dao.MenuDao;
import com.dao.SysUserDao;
import com.pojo.Admin;
import com.pojo.SysUser;
import com.pojo.system.SysMenu;
import com.service.LoginManager;

public class LoginManagerImpl implements LoginManager {
	
	private MenuDao menuDao;
	private SysUserDao sysUserDao;

	public SysUserDao getSysUserDao() {
		return sysUserDao;
	}

	public void setSysUserDao(SysUserDao sysUserDao) {
		this.sysUserDao = sysUserDao;
	}

	public MenuDao getMenuDao() {
		return menuDao;
	}

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	public List<SysMenu> getMenuList() {
		return menuDao.getMenuList();
	}

	public Admin adminLogin(Admin admin) {
		return menuDao.adminLogin(admin);
	}

	@Override
	public SysUser userLogin(SysUser sysUser) {
		return sysUserDao.userLogin(sysUser);
	}

	@Override
	public List<SysMenu> querySysMenuList() {
		return menuDao.querySysMenuList();
	}

	@Override
	public SysMenu querySysMenuByID(SysMenu bean) {
		// TODO Auto-generated method stub
		return null;
	}

}
