package com.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.dao.CourseDao;
import com.pojo.Course;

public class CourseDaoImpl extends BaseDaoImpl implements CourseDao {

	@Override
	public List<Course> getCourse() {
		DetachedCriteria criteria=DetachedCriteria.forClass(Course.class);
		List<Course> list = this.findByCriteria(criteria);
		criteria.addOrder(Order.desc("id"));
		if(list.size() != 0){
			return list;
		}
		return null;
	}

	@Override
	public Course getCourseByID(Integer id) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Course.class);
		criteria.add(Restrictions.eq("id", id));
		List<Course> list = this.findByCriteria(criteria);
		if(list.size() != 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public Course getCourseByName(String courseName) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Course.class);
		criteria.add(Restrictions.eq("courseName", courseName));
		List<Course> list = this.findByCriteria(criteria);
		if(list.size() != 0){
			return list.get(0);
		}
		return null;
	}


	@Override
	public List<Course> getCourseByTeacherID(Integer teacherID) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Course.class);
		criteria.add(Restrictions.eq("TEACHERID", teacherID));
		List<Course> list = this.findByCriteria(criteria);
		criteria.addOrder(Order.desc("id"));
		if(list.size() != 0){
			return list;
		}
		return null;
	}

	
}
