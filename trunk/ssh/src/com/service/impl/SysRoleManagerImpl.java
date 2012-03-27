package com.service.impl;

import com.dao.SysRoleDao;
import com.pojo.system.SysRole;
import com.service.BaseManager;
import com.service.SysRoleManager;

public class SysRoleManagerImpl extends BaseManagerImpl implements SysRoleManager {

	private SysRoleDao sysRoleDao;
	
	
	
	public SysRoleDao getSysRoleDao() {
		return sysRoleDao;
	}



	public void setSysRoleDao(SysRoleDao sysRoleDao) {
		this.sysRoleDao = sysRoleDao;
	}



	@Override
	public SysRole getRoleById(Integer id) {
		return sysRoleDao.getRoleById(id);
	}

}
