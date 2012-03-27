package com.dao;

import java.util.List;

import com.pojo.Course;

public interface CourseDao extends BaseDao {
	public List<Course> getCourse();
	
	public Course getCourseByID(Integer id);
	
	public List<Course> getCourseByTeacherID(Integer teacherID);

	public Course getCourseByName(String courseName);
	
}
