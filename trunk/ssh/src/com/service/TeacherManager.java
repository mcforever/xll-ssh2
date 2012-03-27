package com.service;

import java.util.List;

import com.common.tools.Page;
import com.pojo.Teacher;

public interface TeacherManager extends BaseManager {

	public Teacher doLogin(String userName, String password);

	public Teacher getTeacherByID(Integer id);
	
	public List<Teacher> getTeacherByDeptID(Integer deptID);
	
	public List<Teacher> getTeacher();

	public List<Teacher> getTeacherByTeaPosition(int teaPosition);

	public Page getTeacherPage(Page page, Teacher teacher);

	public void saveOrUpdateTeacher(Teacher teacher);
	

}
