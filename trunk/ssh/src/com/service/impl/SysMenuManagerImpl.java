package com.service.impl;

import java.util.List;

import com.dao.MenuDao;
import com.pojo.system.SysMenu;
import com.service.BaseManager;
import com.service.SysMenuManager;

public class SysMenuManagerImpl extends BaseManagerImpl implements SysMenuManager {
	private MenuDao menuDao;

	@Override
	public SysMenu getSysMenuByID(Integer sysMenuID) {
		return menuDao.getSysMenuByID(sysMenuID);
	}

	@Override
	public List<SysMenu> querySysMenuList() {
		return menuDao.querySysMenuList();
	}
	
	@Override
	public List<SysMenu> getMenuList(String menuIDs) {
		return this.menuDao.getMenuList(menuIDs);
	}

	public MenuDao getMenuDao() {
		return menuDao;
	}

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	@Override
	public List<SysMenu> getMenuListByParentID(Integer parentID) {
		return this.menuDao.getMenuListByParentID(parentID);
	}


}
