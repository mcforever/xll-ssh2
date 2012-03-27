package com.service;

import java.util.List;

import com.common.tools.Page;
import com.pojo.Course;

public interface CourseManager extends BaseManager {
	public List<Course> getCourse();
	
	public Course getCourseByID(Integer id);
	
	public List<Course> getCourseByTeacherID(Integer teacherID);

	public Page getCoursePage(Page page, Course course);

	public Course getCourseByName(String courseName);
}
