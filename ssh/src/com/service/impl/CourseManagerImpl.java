package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.tools.Page;
import com.dao.CourseDao;
import com.pojo.Course;
import com.pojo.system.SysDictionary;
import com.service.CourseManager;

public class CourseManagerImpl extends BaseManagerImpl implements CourseManager {
	
	private CourseDao courseDao;

	@Override
	public List<Course> getCourse() {
		return this.courseDao.getCourse();
	}

	@Override
	public Course getCourseByID(Integer id) {
		return this.courseDao.getCourseByID(id);
	}

	@Override
	public Course getCourseByName(String courseName) {
		return this.courseDao.getCourseByName(courseName);
	}

	@Override
	public List<Course> getCourseByTeacherID(Integer teacherID) {
		return this.getCourseByTeacherID(teacherID);
	}

	@Override
	public Page getCoursePage(Page page, Course course) {
		List<Course> list = null;
		Map<String, Object> paramMap = null;
		if(course != null){
			if(course.getCourseName() != null && !"".equals(course.getCourseName()) ){
				if(paramMap == null){
					paramMap = new HashMap<String, Object>();
				}
				paramMap.put("courseName", course.getCourseName());
			}
			if(course.getTeacher() != null && course.getTeacher().getId() != null){
				if(paramMap == null){
					paramMap = new HashMap<String, Object>();
				}
				paramMap.put("teacher.id", course.getTeacher().getId());
				
			}
		}
		int count = this.courseDao.getResultCount(Course.class, paramMap);
		if(count != 0){
			if(count % page.getPageSize() > 0){
				page.setPageCount(count / page.getPageSize() + 1);
			}else{
				page.setPageCount(count / page.getPageSize());
			}
			page.setResultCount(count);
		}
		list = this.courseDao.findPageByCriteria(Course.class,list,paramMap,null,page.getStart(), page.getPageSize());
		if(list != null){
			page.setResult(list);
		}
		return page;
	}

	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}
}
