package com.service.impl;

import java.util.List;

import com.dao.BaseDao;
import com.service.BaseManager;

public class BaseManagerImpl implements BaseManager {
	private BaseDao baseDao;
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	// 通用查询方法
    public List findByHQL(String hql) {
	return this.getBaseDao().findByHQL(hql);
    }

    public List findByHQL(String hql, Object arg) {
	return this.getBaseDao().findByHQL(hql, arg);
    }

    public List findByHQL(String hql, Object[] args) {
	return this.getBaseDao().findByHQL(hql, args);
    }

	@Override
	public <T> List<T> getDictionary(String typeCode) {
		return this.getBaseDao().getDictionary(typeCode);
	}

	@Override
	public Object getDictionary(String typeCode, Integer dataID) {
		return this.getBaseDao().getDictionary(typeCode, dataID);
	}

	@Override
	public <T> List<T> getDictionary(String typeCode, String dataIDs) {
		return this.getBaseDao().getDictionary(typeCode, dataIDs);
	}
}
