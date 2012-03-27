package com.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.dao.TeacherDao;
import com.pojo.Teacher;

public class TeacherDaoImpl extends BaseDaoImpl implements TeacherDao {

	@Override
	public Teacher doLogin(String userName, String password) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Teacher.class);
		criteria.add(Restrictions.eq("teacherName", userName));
		criteria.add(Restrictions.eq("password", password));
		List<Teacher> list = this.findByCriteria(criteria);
		if(list.size() != 0){
			return (Teacher) list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public List<Teacher> getTeacher() {
		DetachedCriteria criteria=DetachedCriteria.forClass(Teacher.class);
		List<Teacher> list = this.findByCriteria(criteria);
		criteria.addOrder(Order.desc("id"));
		if(list.size() != 0){
			return list;
		}
		return null;
	}

	@Override
	public List<Teacher> getTeacherByDeptID(Integer deptID) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Teacher.class);
		criteria.add(Restrictions.eq("dept.id", deptID));
		List<Teacher> list = this.findByCriteria(criteria);
		criteria.addOrder(Order.desc("id"));
		if(list.size() != 0){
			return list;
		}
		return null;
	}

	@Override
	public Teacher getTeacherByID(Integer id) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Teacher.class);
		criteria.add(Restrictions.eq("id", id));
		List<Teacher> list = this.findByCriteria(criteria);
		if(list.size() != 0){
			return (Teacher) list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public List<Teacher> getTeacherByTeaPosition(int teaPosition) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Teacher.class);
		criteria.add(Restrictions.eq("tposition", teaPosition));
		List<Teacher> list = this.findByCriteria(criteria);
		criteria.addOrder(Order.desc("id"));
		if(list.size() != 0){
			return list;
		}
		return null;
	}
 
}
