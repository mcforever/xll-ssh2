package com.service.impl;

import com.dao.AdminDao;
import com.pojo.Admin;
import com.service.AdminManager;
import com.service.BaseManager;

public class AdminManagerImpl extends BaseManagerImpl implements AdminManager {
	
	private AdminDao adminDao;
	

	public AdminDao getAdminDao() {
		return adminDao;
	}


	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}


	@Override
	public Admin doLogin(String userName, String password) {
		return this.adminDao.doLogin(userName,password);
	}


	@Override
	public Admin getAdminByID(Integer id) {
		return this.adminDao.getAdminByID(id);
	}


	@Override
	public void saveOrUpdateAdmin(Admin admin) {
		this.adminDao.saveOrUpdate(admin);
		
	}

}
