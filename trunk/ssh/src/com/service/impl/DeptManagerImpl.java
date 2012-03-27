package com.service.impl;

import java.util.List;

import com.dao.DeptDao;
import com.pojo.Dept;
import com.service.BaseManager;
import com.service.DeptManager;

public class DeptManagerImpl extends BaseManagerImpl implements DeptManager {
	private DeptDao deptDao;

	@Override
	public List<Dept> getDept() {
		return this.deptDao.getDept();
	}

	@Override
	public Dept getDeptByID(Integer id) {
		return this.deptDao.getDeptByID(id);
	}

	public DeptDao getDeptDao() {
		return deptDao;
	}

	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}	
	

}
