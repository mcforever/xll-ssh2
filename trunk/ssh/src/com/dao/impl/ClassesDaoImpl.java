package com.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.dao.ClassesDao;
import com.pojo.Classes;

public class ClassesDaoImpl extends BaseDaoImpl implements ClassesDao {

	@Override
	public List<Classes> getClasses() {
		DetachedCriteria criteria=DetachedCriteria.forClass(Classes.class);
		List<Classes> list = this.findByCriteria(criteria);
		criteria.addOrder(Order.desc("id"));
		if(list.size() != 0){
			return list;
		}
		return null;
	}

	@Override
	public Classes getClassesByID(Integer id) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Classes.class);
		criteria.add(Restrictions.eq("id", id));
		List<Classes> list = this.findByCriteria(criteria);
		if(list.size() != 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<Classes> getClassesBydeptID(Integer deptID) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Classes.class);
		criteria.add(Restrictions.eq("deptid", deptID));
		List<Classes> list = this.findByCriteria(criteria);
		criteria.addOrder(Order.desc("id"));
		if(list.size() != 0){
			return list;
		}
		return null;
	}

}
