package com.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.dao.AdminDao;
import com.pojo.Admin;

public class AdminDaoImpl extends BaseDaoImpl implements AdminDao {

	@Override
	public Admin doLogin(String userName, String password) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Admin.class);
		criteria.add(Restrictions.eq("adminName", userName));
		criteria.add(Restrictions.eq("password", password));
		List list = this.findByCriteria(criteria);
		if(list.size() != 0){
			return (Admin) list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public Admin getAdminByID(Integer id) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Admin.class);
		criteria.add(Restrictions.eq("id", id));
		List list = this.findByCriteria(criteria);
		if(list.size() != 0){
			return (Admin) list.get(0);
		}else{
			return null;
		}
	}

}
