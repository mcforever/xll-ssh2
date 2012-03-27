package com.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.dao.DeptDao;
import com.pojo.Dept;

public class DeptDaoImpl extends BaseDaoImpl implements DeptDao {

	@Override
	public List<Dept> getDept() {
		DetachedCriteria criteria=DetachedCriteria.forClass(Dept.class);
		List<Dept> list = this.findByCriteria(criteria);
		criteria.addOrder(Order.desc("id"));
		if(list.size() != 0){
			return list;
		}
		return null;
	}

	@Override
	public Dept getDeptByID(Integer id) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Dept.class);
		criteria.add(Restrictions.eq("id", id));
		List<Dept> list = this.findByCriteria(criteria);
		if(list.size() != 0){
			return list.get(0);
		}
		return null;
	}

}
